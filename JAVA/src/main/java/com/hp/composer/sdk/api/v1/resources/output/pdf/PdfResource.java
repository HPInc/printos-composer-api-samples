//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.resources.output.pdf;

import com.hp.composer.sdk.api.v1.resources.common.ResourceIdCollection;

public class PdfResource {
	public PdfResource(){}

	private Output output;

	private String fileName;
	private String templateResourceId;
	private String dataResourceId;
	private String impositionTemplateResourceId;
	private ResourceIdCollection assetsLibraryResourceIdCollection;
	private Boolean applyImposition;
	private Range recordsRange;
	private Integer skipRecords;
	private Long clientTimestampInMilliseconds;

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public Integer getSkipRecords() {
		return skipRecords;
	}

	public void setSkipRecords(Integer skipRecords) {
		this.skipRecords = skipRecords;
	}

	public Long getClientTimestampInMilliseconds() {
		return clientTimestampInMilliseconds;
	}

	public void setClientTimestampInMilliseconds(Long clientTimestampInMilliseconds) {
		this.clientTimestampInMilliseconds = clientTimestampInMilliseconds;
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

	public Boolean getApplyImposition() {
		return applyImposition;
	}

	public void setApplyImposition(Boolean applyImposition) {
		this.applyImposition = applyImposition;
	}

	public Range getRecordsRange() {
		return recordsRange;
	}

	public void setRecordsRange(Range recordsRange) {
		this.recordsRange = recordsRange;
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
		stringBuilder.append("PdfResource:{");

		stringBuilder.append("output:").append(output).append(", ");

		stringBuilder.append("fileName:").append(fileName).append(", ");
		stringBuilder.append("templateResourceId:").append(templateResourceId).append(", ");
		stringBuilder.append("dataResourceId:").append(dataResourceId).append(", ");
		stringBuilder.append("impositionTemplateResourceId:").append(impositionTemplateResourceId).append(", ");
		stringBuilder.append("assetsLibraryResourceIdCollection:").append(assetsLibraryResourceIdCollection).append(", ");
		stringBuilder.append("applyImposition:").append(applyImposition).append(", ");
		stringBuilder.append("recordsRange:").append(recordsRange).append(", ");
		stringBuilder.append("skipRecords:").append(skipRecords).append(", ");
		stringBuilder.append("clientTimestampInMilliseconds:").append(clientTimestampInMilliseconds).append(", ");



		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
