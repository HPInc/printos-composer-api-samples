package com.hp.composer.sdk.api.v1.resources.input.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResource {
	public DataResource(){}

	private Output output;

	private Integer dataFormatDelimiter;
	private String fileName;

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

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
		stringBuilder.append("DataResource:{");
		stringBuilder.append("fileName:").append(fileName).append(", ");
		stringBuilder.append("dataFormatDelimiter:").append(dataFormatDelimiter).append(", ");
		stringBuilder.append("output:").append(output).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
