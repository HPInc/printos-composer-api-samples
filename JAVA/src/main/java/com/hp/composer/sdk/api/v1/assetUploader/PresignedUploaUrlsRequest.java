package com.hp.composer.sdk.api.v1.assetUploader;

public class PresignedUploaUrlsRequest {
	public PresignedUploaUrlsRequest(){}

	private String resourceId;
	private String resourceType;
	private Long fileSize;
	private Long partSize;

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

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Long getPartSize() {
		return partSize;
	}

	public void setPartSize(Long partSize) {
		this.partSize = partSize;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PresignedUploaUrlsRequest:{");
		stringBuilder.append("resourceId:").append(resourceId).append(", ");
		stringBuilder.append("resourceType:").append(resourceType).append(", ");
		stringBuilder.append("fileSize:").append(fileSize).append(", ");
		stringBuilder.append("partSize:").append(partSize).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
