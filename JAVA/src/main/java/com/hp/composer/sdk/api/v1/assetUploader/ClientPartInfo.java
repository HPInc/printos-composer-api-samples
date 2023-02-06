package com.hp.composer.sdk.api.v1.assetUploader;

public class ClientPartInfo {
	public ClientPartInfo(){}

	private int partNumber;
	private PresignedUploadUrl presignedUploadUrl;
	private String eTag;

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public PresignedUploadUrl getPresignedUploadUrl() {
		return presignedUploadUrl;
	}

	public void setPresignedUploadUrl(PresignedUploadUrl presignedUploadUrl) {
		this.presignedUploadUrl = presignedUploadUrl;
	}

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ClientPartInfo:{");
		stringBuilder.append("partNumber:").append(partNumber).append(", ");
		stringBuilder.append("presignedUploadUrl:").append(presignedUploadUrl).append(", ");
		stringBuilder.append("eTag:").append(eTag).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
