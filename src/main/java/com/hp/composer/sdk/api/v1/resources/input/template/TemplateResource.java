package com.hp.composer.sdk.api.v1.resources.input.template;

import com.hp.composer.sdk.api.v1.resources.input.template.Output;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateResource {
	public TemplateResource(){}

	private String fileName;

	private Output output;

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
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

		stringBuilder.append("TemplateResource:{");

		stringBuilder.append("output:").append(output).append(", ");

		stringBuilder.append("fileName:").append(fileName).append(", ");


		stringBuilder.append("}");
		return stringBuilder.toString();
	}
}
