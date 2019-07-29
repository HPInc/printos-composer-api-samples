//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.resources.input.impositionTemplate;

import java.util.List;

public class Output {
	public Output(){}

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


	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Output:{");
		stringBuilder.append("resourceId:").append(resourceId).append(", ");
		stringBuilder.append("status:").append(status).append(", ");
		stringBuilder.append("uploadCompleted:").append(uploadCompleted).append(", ");
		stringBuilder.append("errorType:").append(errorType).append(", ");
		stringBuilder.append("expirationTime:").append(expirationTime).append(", ");
		stringBuilder.append("startWaitingTime:").append(startWaitingTime).append(", ");
		stringBuilder.append("startProcessingTime:").append(startProcessingTime).append(", ");
		stringBuilder.append("resourceCreationTime:").append(resourceCreationTime).append(", ");
		stringBuilder.append("endProcessingTime:").append(endProcessingTime).append(", ");

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
