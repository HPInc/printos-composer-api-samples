package com.hp.composer.sdk.api.v1.assetUploader;

import com.hp.composer.sdk.api.v1.helpers.CollectionToString;

import java.util.List;

public class UploadPartsCollection extends CollectionToString {
	public UploadPartsCollection(){}
	private List<UploadPartInfo> uploadPartInfos;
	private String resourceId;
	private String resourceType;

	public List<UploadPartInfo> getUploadPartInfos() {
		return uploadPartInfos;
	}

	public void setUploadPartInfos(List<UploadPartInfo> uploadPartInfos) {
		this.uploadPartInfos = uploadPartInfos;
	}

	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}




	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UploadPartsCollection:{");
		stringBuilder.append("resourceId").append(":").append(resourceId).append(", ");
		stringBuilder.append("resourceType").append(":").append(resourceType).append(", ");
		stringBuilder.append(collectionToString(uploadPartInfos, "uploadPartInfos", "uploadPartInfo")).append(", ");
		stringBuilder.append("}").append(", ");

		return stringBuilder.toString();
	}
}
