//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.resources.input.data;

public class DataResourceCreation {
	public DataResourceCreation(){}

	private Integer dataFormatDelimiter;
	private String fileName;

	public Integer getDataFormatDelimiter() {
		return dataFormatDelimiter;
	}

	public void setDataFormatDelimiter(Integer dataFormatDelimiter) {
		this.dataFormatDelimiter = dataFormatDelimiter;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DataResourceCreation:{");
		stringBuilder.append("fileName:").append(fileName).append(", ");
		stringBuilder.append("dataFormatDelimiter:").append(dataFormatDelimiter).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
