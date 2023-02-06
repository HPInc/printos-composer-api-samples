package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.input.template.TemplateResourceCreation;

public class VdpTemplate {
	public VdpTemplate(String fileName){
		this.fileName = fileName;
	}

	public String fileName;

	public TemplateResourceCreation toTemplateResourceCreation(){
		TemplateResourceCreation templateResourceCreation = new TemplateResourceCreation();
		templateResourceCreation.setFileName(fileName); // todo: remove file name validation - should allow null here...

		return templateResourceCreation;
	}
}
