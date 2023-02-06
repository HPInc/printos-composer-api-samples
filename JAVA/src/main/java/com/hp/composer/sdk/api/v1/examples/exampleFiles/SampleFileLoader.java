package com.hp.composer.sdk.api.v1.examples.exampleFiles;

import com.hp.composer.sdk.api.v1.configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class SampleFileLoader {
	public static String getFilePath(String fileName)  {
		try{

			String returnPath = Paths.get("sample-files", fileName).toAbsolutePath().toString();

			return returnPath;
		}catch (Throwable throwable){
			throw throwable;
		}
	}
}
