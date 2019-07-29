//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.assetUploader;

public class UploadPartInfo {
	public UploadPartInfo(){}

	private String eTag;
	private Integer partNumber;

	public Integer getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(Integer partNumber) {
		this.partNumber = partNumber;
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
		stringBuilder.append("UploadPartInfo:{");
		stringBuilder.append("eTag:").append(eTag).append(", ");
		stringBuilder.append("partNumber:").append(partNumber).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
