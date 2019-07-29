//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.resources.output.sample;

import com.hp.composer.sdk.api.v1.resources.common.ResourceIdCollection;

public class SampleResourceCreation {
	public SampleResourceCreation(){}

	private String fileName;
	private String templateResourceId;
	private String dataResourceId;
	private String impositionTemplateResourceId;
	private ResourceIdCollection assetsLibraryResourceIdCollection;
	private Long clientTimestampInMilliseconds;
	private Integer skipRecords;
	private String requiredObjectType;
	private RequiredPageRecord requiredPageRecord;
	private Integer requiredSpreadNumber;
	private String outputFormat;
	private Integer deviceScreenHeight;
	private Integer deviceScreenWidth;
	private String pdfFileName;
	private Boolean queryMetadata;

	public Boolean getQueryMetadata() {
		return queryMetadata;
	}

	public void setQueryMetadata(Boolean queryMetadata) {
		this.queryMetadata = queryMetadata;
	}


	public Integer getDeviceScreenHeight() {
		return deviceScreenHeight;
	}

	public void setDeviceScreenHeight(Integer deviceScreenHeight) {
		this.deviceScreenHeight = deviceScreenHeight;
	}

	public Integer getDeviceScreenWidth() {
		return deviceScreenWidth;
	}

	public void setDeviceScreenWidth(Integer deviceScreenWidth) {
		this.deviceScreenWidth = deviceScreenWidth;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTemplateResourceId() {
		return templateResourceId;
	}

	public void setTemplateResourceId(String templateResourceId) {
		this.templateResourceId = templateResourceId;
	}

	public String getDataResourceId() {
		return dataResourceId;
	}

	public void setDataResourceId(String dataResourceId) {
		this.dataResourceId = dataResourceId;
	}

	public String getImpositionTemplateResourceId() {
		return impositionTemplateResourceId;
	}

	public void setImpositionTemplateResourceId(String impositionTemplateResourceId) {
		this.impositionTemplateResourceId = impositionTemplateResourceId;
	}

	public ResourceIdCollection getAssetsLibraryResourceIdCollection() {
		return assetsLibraryResourceIdCollection;
	}

	public void setAssetsLibraryResourceIdCollection(ResourceIdCollection assetsLibraryResourceIdCollection) {
		this.assetsLibraryResourceIdCollection = assetsLibraryResourceIdCollection;
	}

	public Long getClientTimestampInMilliseconds() {
		return clientTimestampInMilliseconds;
	}

	public void setClientTimestampInMilliseconds(Long clientTimestampInMilliseconds) {
		this.clientTimestampInMilliseconds = clientTimestampInMilliseconds;
	}

	public Integer getSkipRecords() {
		return skipRecords;
	}

	public void setSkipRecords(Integer skipRecords) {
		this.skipRecords = skipRecords;
	}

	public String getRequiredObjectType() {
		return requiredObjectType;
	}

	public void setRequiredObjectType(String requiredObjectType) {
		this.requiredObjectType = requiredObjectType;
	}

	public RequiredPageRecord getRequiredPageRecord() {
		return requiredPageRecord;
	}

	public void setRequiredPageRecord(RequiredPageRecord requiredPageRecord) {
		this.requiredPageRecord = requiredPageRecord;
	}

	public Integer getRequiredSpreadNumber() {
		return requiredSpreadNumber;
	}

	public void setRequiredSpreadNumber(Integer requiredSpreadNumber) {
		this.requiredSpreadNumber = requiredSpreadNumber;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}



	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SampleResourceCreation:{");
		stringBuilder.append("fileName:").append(fileName).append(", ");
		stringBuilder.append("templateResourceId:").append(templateResourceId).append(", ");
		stringBuilder.append("dataResourceId:").append(dataResourceId).append(", ");
		stringBuilder.append("impositionTemplateResourceId:").append(impositionTemplateResourceId).append(", ");
		stringBuilder.append("assetsLibraryResourceIdCollection:").append(assetsLibraryResourceIdCollection).append(", ");
		stringBuilder.append("clientTimestampInMilliseconds:").append(clientTimestampInMilliseconds).append(", ");
		stringBuilder.append("skipRecords:").append(skipRecords).append(", ");
		stringBuilder.append("requiredObjectType:").append(requiredObjectType).append(", ");
		stringBuilder.append("requiredSpreadNumber:").append(requiredSpreadNumber).append(", ");
		stringBuilder.append("outputFormat:").append(outputFormat).append(", ");
		stringBuilder.append("queryMetadata:").append(queryMetadata).append(", ");
		stringBuilder.append("deviceScreenHeight:").append(deviceScreenHeight).append(", ");
		stringBuilder.append("deviceScreenWidth:").append(deviceScreenWidth).append(", ");
		stringBuilder.append("pdfFileName:").append(pdfFileName).append(", ");
		if(requiredPageRecord != null){
			stringBuilder.append("requiredPageRecord:").append(requiredPageRecord.toString()).append(", ");
		}else{
			stringBuilder.append("requiredPageRecord:").append("null").append(", ");
		}
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
