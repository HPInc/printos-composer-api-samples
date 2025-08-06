package com.hp.composer.sdk.api.v1.resources.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsError implements Serializable {
	public SmsError(){}

	private int statusCode;
	private String message;
	private String moreInfoUrl;
	private String developerInfo;
	private int subCode;
	private String serviceName;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMoreInfoUrl() {
		return moreInfoUrl;
	}

	public void setMoreInfoUrl(String moreInfoUrl) {
		this.moreInfoUrl = moreInfoUrl;
	}

	public String getDeveloperInfo() {
		return developerInfo;
	}

	public void setDeveloperInfo(String developerInfo) {
		this.developerInfo = developerInfo;
	}

	public int getSubCode() {
		return subCode;
	}

	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SmsError:{");
		stringBuilder.append("statusCode:").append(statusCode).append(", ");
		stringBuilder.append("message:").append(message).append(", ");
		stringBuilder.append("moreInfoUrl:").append(moreInfoUrl).append(", ");
		stringBuilder.append("developerInfo:").append(developerInfo).append(", ");
		stringBuilder.append("subCode:").append(subCode).append(", ");
		stringBuilder.append("serviceName:").append(serviceName).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
