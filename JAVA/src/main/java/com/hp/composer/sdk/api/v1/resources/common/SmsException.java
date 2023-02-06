package com.hp.composer.sdk.api.v1.resources.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsException {
	public SmsException(){}

	private SmsError smsError;


	public SmsError getSmsError() {
		return smsError;
	}

	public void setSmsError(SmsError smsError) {
		this.smsError = smsError;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SmsException:{");
		stringBuilder.append("smsError:").append(smsError).append(", ");

		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
