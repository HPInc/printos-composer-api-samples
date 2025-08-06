package com.hp.composer.sdk.api.v1.assetUploader;

import com.hp.composer.sdk.api.v1.helpers.CollectionToString;

import java.util.List;

public class PresignedUploadUrlCollection extends CollectionToString<PresignedUploadUrl> {
	public PresignedUploadUrlCollection(){}

	private List<PresignedUploadUrl> presignedUploadUrls;


	public List<PresignedUploadUrl> getPresignedUploadUrls() {
		return presignedUploadUrls;
	}

	public void setPresignedUploadUrls(List<PresignedUploadUrl> presignedUploadUrls) {
		this.presignedUploadUrls = presignedUploadUrls;
	}

	@Override
	public String toString(){
		return collectionToString(presignedUploadUrls, "PresignedUploadUrlCollection", "PresignedUploadUrl");
	}
}
