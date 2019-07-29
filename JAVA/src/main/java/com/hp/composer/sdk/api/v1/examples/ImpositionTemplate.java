//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.input.impositionTemplate.ImpositionTemplateResourceCreation;

public class ImpositionTemplate {
	public ImpositionTemplate(String fileName){
		this.fileName = fileName;
	}
	public String fileName;


	public ImpositionTemplateResourceCreation toImpositionTemplateResourceCreation(){
		ImpositionTemplateResourceCreation impositionTemplateResourceCreation = new ImpositionTemplateResourceCreation();

		impositionTemplateResourceCreation.setFileName(fileName); // todo: remove file name validation - should allow null here...

		return impositionTemplateResourceCreation;
	}
}
