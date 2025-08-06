package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.input.assetsLibrary.AssetsLibraryResourceCreation;

public class AssetsLibrary {
	public AssetsLibrary(String fileName){
		this.fileName = fileName;
	}
	public String fileName;


	public AssetsLibraryResourceCreation toAssetsLibraryCreation(){
		AssetsLibraryResourceCreation assetsLibraryResourceCreation = new AssetsLibraryResourceCreation();

		assetsLibraryResourceCreation.setFileName(fileName); // todo: remove file name validation - should allow null here...

		return assetsLibraryResourceCreation;
	}
}
