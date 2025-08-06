package com.hp.composer.sdk.api.v1.examples;

import java.util.HashMap;
import java.util.Set;

public class Examples {
	private Examples(){

		examples = new HashMap<>();

	}

	public static Examples getSamples(){
		if(theExamples == null){
			theExamples = new Examples();
		}
		return theExamples;
	}

	private static Examples theExamples;



	private HashMap<String, Example> examples;

	public void addExample(String sampleName, Example example){
		examples.put(sampleName, example);
	}

	public Set<String> getExampleSet(){
		return examples.keySet();
	}

	public Example getExample(String exampleName){
		return examples.get(exampleName);
	}
}
