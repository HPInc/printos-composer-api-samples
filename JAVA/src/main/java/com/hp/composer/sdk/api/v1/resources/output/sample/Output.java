package com.hp.composer.sdk.api.v1.resources.output.sample;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {

	public Output(){}

	private String downloadUrl;
	private Boolean duplex;
	private Integer totalNumberOfSheets;

	private String resourceId;
	private String status;
	private Boolean uploadCompleted;
	private String errorType;
	private Long expirationTime;
	private List<String> warningMessages;
	private List<String> errorMessages;
	private Long startWaitingTime;
	private Long startProcessingTime;
	private Long endProcessingTime;
	private Long resourceCreationTime;

	public Long getResourceCreationTime() {
		return resourceCreationTime;
	}

	public void setResourceCreationTime(Long resourceCreationTime) {
		this.resourceCreationTime = resourceCreationTime;
	}


	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getUploadCompleted() {
		return uploadCompleted;
	}

	public void setUploadCompleted(Boolean uploadCompleted) {
		this.uploadCompleted = uploadCompleted;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public List<String> getWarningMessages() {
		return warningMessages;
	}

	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Long getStartWaitingTime() {
		return startWaitingTime;
	}

	public void setStartWaitingTime(Long startWaitingTime) {
		this.startWaitingTime = startWaitingTime;
	}

	public Long getStartProcessingTime() {
		return startProcessingTime;
	}

	public void setStartProcessingTime(Long startProcessingTime) {
		this.startProcessingTime = startProcessingTime;
	}

	public Long getEndProcessingTime() {
		return endProcessingTime;
	}

	public void setEndProcessingTime(Long endProcessingTime) {
		this.endProcessingTime = endProcessingTime;
	}


	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Boolean getDuplex() {
		return duplex;
	}

	public void setDuplex(Boolean duplex) {
		this.duplex = duplex;
	}

	public Integer getTotalNumberOfSheets() {
		return totalNumberOfSheets;
	}

	public void setTotalNumberOfSheets(Integer totalNumberOfSheets) {
		this.totalNumberOfSheets = totalNumberOfSheets;
	}


	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Output:{");

		stringBuilder.append("downloadUrl:").append(downloadUrl).append(", ");
		stringBuilder.append("duplex:").append(duplex).append(", ");
		stringBuilder.append("totalNumberOfSheets:").append(totalNumberOfSheets).append(", ");


		stringBuilder.append("resourceId:").append(resourceId).append(", ");
		stringBuilder.append("status:").append(status).append(", ");
		stringBuilder.append("uploadCompleted:").append(uploadCompleted).append(", ");
		stringBuilder.append("errorType:").append(errorType).append(", ");
		stringBuilder.append("expirationTime:").append(expirationTime).append(", ");
		stringBuilder.append("startWaitingTime:").append(startWaitingTime).append(", ");
		stringBuilder.append("startProcessingTime:").append(startProcessingTime).append(", ");
		stringBuilder.append("endProcessingTime:").append(endProcessingTime).append(", ");
		stringBuilder.append("resourceCreationTime:").append(resourceCreationTime).append(", ");

		stringBuilder.append("warningMessages:");
		if (warningMessages == null) {
			stringBuilder.append("null");
		}else{
			stringBuilder.append("[");
			for (String warningMessage: warningMessages) {
				stringBuilder.append(warningMessage).append(",");
			}
			stringBuilder.append("]");
		}

		stringBuilder.append("}");

		stringBuilder.append("errorMessages:");
		if (errorMessages == null) {
			stringBuilder.append("null");
		}else{
			stringBuilder.append("[");
			for (String errorMessage: errorMessages) {
				stringBuilder.append(errorMessage).append(",");
			}
			stringBuilder.append("]");
		}



		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
