package com.hp.composer.sdk.api.v1.assetUploader;

import com.hp.composer.sdk.api.v1.helpers.Client;
import com.hp.composer.sdk.api.v1.helpers.NiceJson;
import com.hp.composer.sdk.api.v1.resources.common.ResourceType;
import com.hp.composer.sdk.api.v1.resources.common.SmsException;
import com.hp.composer.sdk.api.v1.configuration.Configuration;
import com.hp.composer.sdk.api.v1.helpers.Hmac;
import com.hp.composer.sdk.api.v1.helpers.RestClientBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AssetUploader {
	public AssetUploader(String resourceId, String filePath, ResourceType resourceType){
		this.resourceId = resourceId;
		this.filePath = filePath;
		this.resourceType = resourceType;
	}

	private String resourceId;
	private String filePath;
	ResourceType resourceType;

	public Boolean upload(){
		System.out.println("=========================================================================================================");
		System.out.println(String.format("Uploading %s for %s resource - resourceId=%s", filePath, resourceType, resourceId));

		// Upload is always in context certain resource ID
		// The Composer API Support upload of the files in parts:
		//		1. Create part PUT URLs - for uploading of each part
		//		2. Upload part for each URL - get etag as response representing the part
		//		3. report on completion once all etags received.
		//
		// Upload in parts has the following advantages:
		//		1. Performance - Better performance by uploading several parts in parallel
		//		2. Robustness - reattempt uploading of a part in case of temporary network issue - repeat the failed part upload.
		//		3. User Friendly - by enabling resume of upload - keep track which parts you already uploaded - resume by uploading the remaining parts only.

		// in this example we use certain size definition for part - Configuration.partSizeInBytes
		// client is free to choose any part size per need with the following conditions:
		//		1. Should not end up with more than 200 parts per upload
		//		2. Total file size is limited by Composer to 3GB

		// Note - in this example we have a very simple code - we do not do reattempt of part upload in case of failure.

		PresignedUploadUrlCollection presignedUploadUrlCollection = createPresginedUploadUrls();
		UploadPartsCollection uploadPartsCollection = uploadFileInParts(presignedUploadUrlCollection);
		uploadCompleted(uploadPartsCollection);

		return true;
	}

	// Creating PUT Upload presigned URLs.
	// POST .../composer/sdk/v1/assets/put-urls
	private PresignedUploadUrlCollection createPresginedUploadUrls(){

		System.out.println("=========================================================================================================");

		String methodName="AssetUploader:createPresginedUploadUrls";
		System.out.println(String.format("%s - getting presigned PUT URLs", methodName));

		File file = new File(filePath);
		Long fileSize = file.length();
		PresignedUploaUrlsRequest presignedUploaUrlsRequest = new PresignedUploaUrlsRequest();
		presignedUploaUrlsRequest.setPartSize(Configuration.partSizeInBytes);
		presignedUploaUrlsRequest.setFileSize(fileSize);
		presignedUploaUrlsRequest.setResourceId(resourceId);
		presignedUploaUrlsRequest.setResourceType(resourceType.toString());


		return Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/assets/put-urls",
				presignedUploaUrlsRequest, PresignedUploadUrlCollection.class, 201);

	}

	// POST .../composer/sdk/v1/assets/parts
	private void uploadCompleted(UploadPartsCollection uploadPartsCollection){

		System.out.println("=========================================================================================================");

		String methodName="AssetUploader:uploadCompleted";
		System.out.println(String.format("%s - report on parts upload completion ", methodName));

		Response response = null;

		//try{
			String relativeUrl = "/composer/sdk/v1/assets/parts";
			String fullUrl = Configuration.apiBaseUrl + relativeUrl;

			Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/assets/parts", uploadPartsCollection, null, 204);

	}

	private UploadPartsCollection uploadFileInParts(PresignedUploadUrlCollection presignedUploadUrlCollection){

		List<ClientPartInfo> clientPartInfos = new ArrayList<>();

		// arrange parts
		for(int iPart = 0; iPart < presignedUploadUrlCollection.getPresignedUploadUrls().size(); iPart++){
			ClientPartInfo clientPartInfo = new ClientPartInfo();
			clientPartInfo.setPartNumber(iPart+1);
			clientPartInfo.setPresignedUploadUrl(presignedUploadUrlCollection.getPresignedUploadUrls().get(iPart));
			clientPartInfos.add(clientPartInfo);
		}

		clientPartInfos.parallelStream().forEach(
				(presignedUploadUrl) -> {
					String etag = uploadPartDirectly(presignedUploadUrl.getPartNumber(),Configuration.partSizeInBytes,
							presignedUploadUrl.getPresignedUploadUrl().getPresignedUrl());
					presignedUploadUrl.seteTag(etag);
				}
		);



		List<UploadPartInfo> uploadPartInfos = new ArrayList<>();
		for(int iPart = 0; iPart < clientPartInfos.size(); iPart++){
			UploadPartInfo uploadPartInfo = new UploadPartInfo();
			uploadPartInfo.seteTag(clientPartInfos.get(iPart).geteTag());
			uploadPartInfo.setPartNumber(clientPartInfos.get(iPart).getPartNumber());
			uploadPartInfos.add(uploadPartInfo);
		}

		UploadPartsCollection uploadPartsCollection = new UploadPartsCollection();
		uploadPartsCollection.setResourceId(resourceId);
		uploadPartsCollection.setResourceType(resourceType.toString());
		uploadPartsCollection.setUploadPartInfos(uploadPartInfos);

		return  uploadPartsCollection;
	}




	private String uploadPartDirectly(int partNumber, Long partSize, String uploadUrl) {
		String methodName = "AssetUploader:uploadPartDirectly";
		FileInputStream fis = null;
		String eTag = null;
		try {

			fis = new FileInputStream(filePath);
			int i = partNumber - 1;
			fis.skip(i * partSize);
			eTag = directUpload(fis, partSize, uploadUrl);


		} catch (IOException e) {
			String errorMessage = String.format("%s encountered with exception %s", methodName, e);
			System.out.println(errorMessage);
			throw new RuntimeException(errorMessage);
		} finally {
			IOUtils.closeQuietly(fis);
		}

		if (eTag == null) {
			String errorMessage = String.format("%s eTag is null", methodName);
			System.out.println(errorMessage);
			throw new RuntimeException(errorMessage);
		}else{
			return eTag;
		}
	}

	private String directUpload(InputStream is, Long partSize, String uploadUrl) {
		String methodName = "AssetUploader:directUpload";
		OutputStream out = null;
		String eTag = null;
		// write data
		try {

			Proxy proxy = null;
			if(Configuration.useProxyForPartsUpload){
				InetSocketAddress inetSocketAddress = new InetSocketAddress(Configuration.proxyHost, Configuration.proxyPort);
				proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
			}

			HttpURLConnection connection = null;
			URL url = new URL(uploadUrl);
			if(proxy != null){
				connection = (HttpURLConnection) url.openConnection(proxy);
			}else{
				connection = (HttpURLConnection) url.openConnection();
			}

			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/octet-stream");
			out = connection.getOutputStream();
			int count = 0;
			byte[] data = new byte[partSize.intValue()];
			count = is.read(data);
			out.write(data, 0, count);
			out.flush();

			eTag = connection.getHeaderField("ETag");
			eTag = eTag.replace("\"","" );

			int responseCode = connection.getResponseCode();
			if (responseCode != HttpStatus.SC_OK) {
				String errorMessage = String.format("%s upload to AWS S3 return error code %s", methodName, responseCode);
				System.out.println(errorMessage);
				throw new RuntimeException(errorMessage);
			}
		} catch (IOException e) {
			String errorMessage = String.format("%s encountered with IOException %s", methodName, e);
			System.out.println(errorMessage);
			throw new RuntimeException(errorMessage);
		} catch (Exception e) {
			String errorMessage = String.format("%s encountered with Exception %s", methodName, e);
			System.out.println(errorMessage);
			throw new RuntimeException(errorMessage);
		}
		finally {
			IOUtils.closeQuietly(out);
		}
		return eTag;
	}
}
