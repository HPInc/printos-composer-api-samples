package com.hp.composer.sdk.api.v1.resources.input.impositionTemplate;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpositionTemplateResourceCreation {
	public ImpositionTemplateResourceCreation(){}

	private String fileName;


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ImpositionTemplateResourceCreation:{");
		stringBuilder.append("fileName:").append(fileName).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

}
