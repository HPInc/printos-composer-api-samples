package com.hp.composer.sdk.api.v1.assetUploader;

public class PresignedUploadUrl {

	public PresignedUploadUrl(){}

	private String presignedUrl;

	public String getPresignedUrl() {
		return presignedUrl;
	}

	public void setPresignedUrl(String presignedUrl) {
		this.presignedUrl = presignedUrl;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PresignedUploadUrl:{");
		stringBuilder.append("presignedUrl:").append(presignedUrl).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
