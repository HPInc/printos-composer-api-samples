package com.hp.composer.sdk.api.v1.resources.output.sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequiredPageRecord {
	public RequiredPageRecord(){}

	private Integer recordNumber;
	private Integer pageNumber;

	public Integer getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("RequiredPageRecord:{");
		stringBuilder.append("recordNumber:").append(recordNumber).append(", ");
		stringBuilder.append("pageNumber:").append(pageNumber).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
