package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.common.ResourceIdCollection;
import com.hp.composer.sdk.api.v1.resources.output.sample.*;

import java.util.ArrayList;
import java.util.List;

public class SampleOutput {
	public SampleOutput(String sampleFileNameOutput, String pdfFileNameForImpositionTextMark, RequiredObjectType requiredObjectType,
						Integer requiredSpreadNumber, Integer requiredPageNumber, Integer requiredRecordNumber,
						OutputFormat outputFormat, Integer skipRecords){
		this.sampleFileNameOutput = sampleFileNameOutput;
		this.pdfFileNameForImpositionTextMark = pdfFileNameForImpositionTextMark;
		this.requiredObjectType = requiredObjectType;
		this.requiredSpreadNumber = requiredSpreadNumber;
		this.requiredPageNumber = requiredPageNumber;
		this.requiredRecordNumber = requiredRecordNumber;
		this.outputFormat = outputFormat;

		this.skipRecords = skipRecords;
	}

	public String sampleFileNameOutput;
	public String pdfFileNameForImpositionTextMark;
	public RequiredObjectType requiredObjectType;
	public Integer requiredSpreadNumber;
	public Integer requiredPageNumber;
	public Integer requiredRecordNumber;
	public OutputFormat outputFormat;
	public Integer skipRecords;

	public SampleResourceCreation toSampleResourceCreation(String templateResourceId, String dataResourceId, String impositionTemplateResourceId, String assetsLibraryResourceId){
		SampleResourceCreation sampleResourceCreation = new SampleResourceCreation();
		sampleResourceCreation.setTemplateResourceId(templateResourceId);
		sampleResourceCreation.setDataResourceId(dataResourceId);
		sampleResourceCreation.setImpositionTemplateResourceId(impositionTemplateResourceId);

		if(assetsLibraryResourceId != null) {
			ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
			List<String> assetsLibraryIds = new ArrayList<>();
			assetsLibraryIds.add(assetsLibraryResourceId);
			resourceIdCollection.setResourceIds(assetsLibraryIds);
			sampleResourceCreation.setAssetsLibraryResourceIdCollection(resourceIdCollection);
		}

		sampleResourceCreation.setClientTimestampInMilliseconds(System.currentTimeMillis());
		sampleResourceCreation.setFileName(sampleFileNameOutput);
		sampleResourceCreation.setRequiredObjectType(requiredObjectType.toString());


		if(requiredObjectType.equals(RequiredObjectType.NonImposedPageRecord)){
			RequiredPageRecord requiredPageRecord = new RequiredPageRecord();
			requiredPageRecord.setPageNumber(requiredPageNumber);
			requiredPageRecord.setRecordNumber(requiredRecordNumber);

			sampleResourceCreation.setRequiredPageRecord(requiredPageRecord);
		}else{
			sampleResourceCreation.setRequiredSpreadNumber(requiredSpreadNumber);
		}


		sampleResourceCreation.setOutputFormat(outputFormat.toString());
		sampleResourceCreation.setPdfFileName(pdfFileNameForImpositionTextMark);
		sampleResourceCreation.setDeviceScreenWidth(1920);
		sampleResourceCreation.setDeviceScreenHeight(1080);
		sampleResourceCreation.setSkipRecords(skipRecords);
		sampleResourceCreation.setQueryMetadata(true);

		return sampleResourceCreation;
	}
}
