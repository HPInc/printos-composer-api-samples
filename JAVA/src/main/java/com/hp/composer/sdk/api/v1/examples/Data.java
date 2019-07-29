//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.input.data.DataResourceCreation;

public class Data {
	public Data(String fileName, Integer delimiter){
		this.fileName = fileName;
		this.delimiter  = delimiter;
	}

	public String fileName;
	public Integer delimiter;


	public DataResourceCreation toDataResourceCreation(){
		DataResourceCreation dataResourceCreation = new DataResourceCreation();
		dataResourceCreation.setFileName(fileName); // todo: remove file name validation - should allow null here...
		dataResourceCreation.setDataFormatDelimiter(delimiter);
		return  dataResourceCreation;
	}
}
