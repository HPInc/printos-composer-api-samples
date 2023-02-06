package com.hp.composer.sdk.api.v1.examples;

import com.hp.composer.sdk.api.v1.resources.common.ResourceIdCollection;
import com.hp.composer.sdk.api.v1.resources.output.pdf.Range;
import com.hp.composer.sdk.api.v1.resources.output.pdf.PdfResourceCreation;

import java.util.ArrayList;
import java.util.List;

public class PdfOutput {
	public PdfOutput(String fileName,
					 Boolean applyImposition,
					 Integer recordsRangeFrom,
					 Integer recordsRangeTo,
					 Integer skipRecords,
					 Integer numberOfChunkedProcessing,
					 String chunkedProcessingMergeFormat){

		this.fileName = fileName;
		this.applyImposition = applyImposition;
		this.recordsRangeFrom = recordsRangeFrom;
		this.recordsRangeTo = recordsRangeTo;
		this.skipRecords = skipRecords;
		this.numberOfChunkedProcessing = numberOfChunkedProcessing;
		this.chunkedProcessingMergeFormat = chunkedProcessingMergeFormat;
	}

	public String fileName;
	public Boolean applyImposition;
	public Integer recordsRangeFrom;
	public Integer recordsRangeTo;
	public Integer skipRecords;
	public Integer numberOfChunkedProcessing;
	public String chunkedProcessingMergeFormat;


	public PdfResourceCreation toPdfResourceCreation(String templateResourceId, String dataResourceId, String impositionTemplateResourceId, String assetsLibraryResourceId){
		PdfResourceCreation pdfResourceCreation = new PdfResourceCreation();
		pdfResourceCreation.setFileName(fileName);
		pdfResourceCreation.setTemplateResourceId(templateResourceId);
		pdfResourceCreation.setDataResourceId(dataResourceId);
		pdfResourceCreation.setImpositionTemplateResourceId(impositionTemplateResourceId);
		pdfResourceCreation.setApplyImposition(applyImposition);
		pdfResourceCreation.setNumberOfChunkedProcessing(numberOfChunkedProcessing);
		pdfResourceCreation.setChunkedProcessingMergeFormat(chunkedProcessingMergeFormat);

		if(recordsRangeFrom != null && recordsRangeTo != null){
			Range range = new Range();
			range.setFrom(recordsRangeFrom);
			range.setTo(recordsRangeTo);
			pdfResourceCreation.setRecordsRange(range);
		}
		pdfResourceCreation.setClientTimestampInMilliseconds(System.currentTimeMillis());
		pdfResourceCreation.setSkipRecords(skipRecords);

		if(assetsLibraryResourceId != null) {
			ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
			List<String> assetsLibraryIds = new ArrayList<>();
			assetsLibraryIds.add(assetsLibraryResourceId);
			resourceIdCollection.setResourceIds(assetsLibraryIds);
			pdfResourceCreation.setAssetsLibraryResourceIdCollection(resourceIdCollection);
		}

		return pdfResourceCreation;
	}
}
