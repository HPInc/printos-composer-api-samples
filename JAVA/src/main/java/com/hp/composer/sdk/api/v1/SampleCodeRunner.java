package com.hp.composer.sdk.api.v1;

import com.hp.composer.sdk.api.v1.assetUploader.AssetUploader;
import com.hp.composer.sdk.api.v1.examples.exampleFiles.SampleFileLoader;
import com.hp.composer.sdk.api.v1.helpers.Client;
import com.hp.composer.sdk.api.v1.resources.common.LifespanCollection;
import com.hp.composer.sdk.api.v1.resources.common.ResourceIdCollection;
import com.hp.composer.sdk.api.v1.resources.common.ResourceType;
import com.hp.composer.sdk.api.v1.configuration.Configuration;
import com.hp.composer.sdk.api.v1.resources.input.assetsLibrary.AssetsLibraryResource;
import com.hp.composer.sdk.api.v1.resources.input.assetsLibrary.AssetsLibraryResourceCreation;
import com.hp.composer.sdk.api.v1.resources.input.data.DataResource;
import com.hp.composer.sdk.api.v1.resources.input.data.DataResourceCreation;
import com.hp.composer.sdk.api.v1.resources.input.impositionTemplate.ImpositionTemplateResource;
import com.hp.composer.sdk.api.v1.resources.input.impositionTemplate.ImpositionTemplateResourceCreation;
import com.hp.composer.sdk.api.v1.resources.input.template.TemplateResource;
import com.hp.composer.sdk.api.v1.resources.input.template.TemplateResourceCreation;
import com.hp.composer.sdk.api.v1.resources.output.pdf.PdfResource;
import com.hp.composer.sdk.api.v1.resources.output.pdf.PdfResourceCreation;
import com.hp.composer.sdk.api.v1.resources.output.sample.*;
import com.hp.composer.sdk.api.v1.examples.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SampleCodeRunner {
	public static void main(String[] args){

		System.out.println("Welcome to Composer SDK Sample Code...\n\n");

		Boolean successCommandLineParsing = processCommandLine(args);

		if(!successCommandLineParsing){
			return;
		}



		// The following is just to sort the examples in a convenient way before we start.
		Examples examples = Examples.getSamples();

		// example 1
		examples.addExample("Simple Business Card",
				new Example(
						true, // should run this sample?
						new VdpTemplate(
								"simpleBusinessCard.hpd" // the name of the VDP Template input file
						),
						new Data(
								"simpleBusinessCard.csv", // the name of the Data input files with records inside.
								44 // the data file delimiter format in Ascii - in this case comma delimiter
						),
						new ImpositionTemplate( // OPTIONAL
								"simpleBusinessCard.impp" // the name of the Imposition Template input file
						),
						null, // no assets library in this example
						new SampleOutput( // OPTIONAL - A sample of the output - generate single page\record or spread with imposition (when exist) without processing the entire data.
								"simpleBusinessCard.jpg", // name for Sample file to get as output - in this case a jpg file
								"simpleBusinessCard.pdf", // this parameter is being used in case of Imposition with text mark containing the PDF name - the Composer would put this value as PDF Name inside the text mark
								RequiredObjectType.NonImposedPageRecord, // request specified non imposed record/page
								null, // required spread number - null in this example - this example include page/record sample request
								1, // required page number
								2, // required Record Number
								OutputFormat.JPEG, // required output format
								1 // skip the first record of the input data as it is just header with field names.

						),
						new PdfOutput(
								"simpleBusinessCard.pdf", // name for PDF file to get as output
								true, // whether to apply imposition or not
								5, // optional - use only part of the records - range start from record 5.
								10, // optional - use only part of the records - range ends at record 10.
								1, // skip the first record of the input data as it is just header with field names.
								null,
								null
						),
						true, // whether to demonstrate touch api in this example
						true // should delete resources at the end
				)
		);


		// example 2
		examples.addExample("Mosaic Notebook",
				new Example(
						// NOTE - In this example we do not upload imposition template file nor use Imposition template Resource.
						// This example contain imposition embedded inside the template - an option available at SmartStream Designer for InDesign when packing a template.

						false,  // should run this sample?
						new VdpTemplate(
								"mosaicNotebook.hpd" // the name of the VDP Template input file
						),
						new Data(
								"mosaicNotebook.txt", // the name of the Data input files with records inside.
								9 // the data file delimiter format in Ascii - in this case tab delimiter
						),
						null, // no imposition template in this example
						null, // no assets library in this example
						new SampleOutput( // OPTIONAL - A sample of the output - generate single page\record or spread with imposition (when exist) without processing the entire data.
								"mosaicNotebook.pdf", // // name for Sample file to get as output - in this a PDF
								"mosaicNotebook.pdf", // this parameter is being used in case of Imposition with text mark containing the PDF name - the Composer would put this value as PDF Name inside the text mark
								RequiredObjectType.ImposedSpread, // request specified imposed spread - only in case imposition exist.
								2, // required spread number - null in this example - this example include imposed  spread sample request
								null, // required page number - null in this example - this example include imposed spread sample request
								null, // required Record Number
								OutputFormat.PDF, // required output format
								1 // skip the first record of the input data as it is just header with field names.

						),
						new PdfOutput(
								"mosaicNoteBook.pdf", // name for PDF file to get as output
								true, // whether to apply imposition or not
								null, // optional - use only part of the records - in this case we wish to make full PDF with entire set of records supplied by the data file, therefore set as null.
								null, // optional - use only part of the records- in this case we wish to make full PDF with entire set of records supplied by the data file, therefore set as null.
								1,  // skip the first record of the input data as it is just header with field names.
								null,
								null
						),
						true, // whether to demonstrate touch api in this example
						false // should delete resources at the end
				)
		);

		// example 3
		examples.addExample("Example with Assets Library",
				new Example(
						false, // should run this sample?
						new VdpTemplate(
								"ImageAssetsExample.hpd" // the name of the VDP Template input file
						),
						new Data(
								"ImageAssetsExample.txt", // the name of the Data input files with records inside.
								9 // the data file delimiter format in Ascii - in this case comma delimiter
						),
						null, // OPTIONAL
						new AssetsLibrary( // OPTIONAL
								"ImageAssetsExample.zip"
						),
						new SampleOutput( // OPTIONAL - A sample of the output - generate single page\record or spread with imposition (when exist) without processing the entire data.
								"ImageAssetsExample.jpg", // name for Sample file to get as output - in this case a jpg file
								"ImageAssetsExample.pdf", // this parameter is being used in case of Imposition with text mark containing the PDF name - the Composer would put this value as PDF Name inside the text mark
								RequiredObjectType.NonImposedPageRecord, // request specified non imposed record/page
								null, // required spread number - null in this example - this example include page/record sample request
								1, // required page number
								3, // required Record Number
								OutputFormat.JPEG, // required output format
								1 // skip the first record of the input data as it is just header with field names.

						),
						new PdfOutput(
								"ImageAssetsExample.pdf", // name for PDF file to get as output
								false, // whether to apply imposition or not
								null, // optional - use only part of the records - range start from record 5.
								null, // optional - use only part of the records - range ends at record 10.
								1, // skip the first record of the input data as it is just header with field names.
								null,
								null
						),
						true, // whether to demonstrate touch api in this example
						false // should delete resources at the end
				)
		);

		// example 4
		examples.addExample("6pages - processing using multiple chunks - output single merged PDF output",
				new Example(
						false, // should run this sample?
						new VdpTemplate(
								"6pages.hpd" // the name of the VDP Template input file
						),
						new Data(
								"6pages.txt", // the name of the Data input files with records inside.
								9 // the data file delimiter format in Ascii - in this case comma delimiter
						),
						null,
						null, // no assets library in this example
						null,

						new PdfOutput(
								"6pages.pdf", // name for PDF file to get as output
								true, // whether to apply imposition or not
								null, // optional - use only part of the records - range start from record 5.
								null, // optional - use only part of the records - range ends at record 10.
								1, // skip the first record of the input data as it is just header with field names.
								3,
								"PDF"
						),
						true, // whether to demonstrate touch api in this example
						true // should delete resources at the end
				)
		);

		// example 5
		examples.addExample("6pages - processing using multiple chunks - packing all inside one ZIP file",
				new Example(
						true, // should run this sample?
						new VdpTemplate(
								"6pages.hpd" // the name of the VDP Template input file
						),
						new Data(
								"6pages.txt", // the name of the Data input files with records inside.
								9 // the data file delimiter format in Ascii - in this case comma delimiter
						),
						null,
						null, // no assets library in this example
						null,

						new PdfOutput(
								"6pages.zip", // name for PDF file to get as output
								true, // whether to apply imposition or not
								null, // optional - use only part of the records - range start from record 5.
								null, // optional - use only part of the records - range ends at record 10.
								1, // skip the first record of the input data as it is just header with field names.
								3,
								"ZIP"
						),
						true, // whether to demonstrate touch api in this example
						true // should delete resources at the end
				)
		);


		// example 6
		examples.addExample("Fonts warnings - ZIP output",
				new Example(
						true,
						new VdpTemplate(
								"Fonts warnings.hpd" // the name of the VDP Template input file
						),
						new Data(
								"Fonts warnings.txt", // the name of the Data input files with records inside.
								9 // the data file delimiter format in Ascii - in this case comma delimiter
						),
						null,
						null, // no assets library in this example
						null,
						new PdfOutput(
								"Fonts warnings.pdf", // name for PDF file to get as output
								true, // whether to apply imposition or not
								null, // optional - use only part of the records - range start from record 5.
								null, // optional - use only part of the records - range ends at record 10.
								1, // skip the first record of the input data as it is just header with field names.
								2,
								"PDF"
						),
						true, // whether to demonstrate touch api in this example
						true // should delete resources at the end
				)
		);


		// now that we have our examples information set, and all API Rest clients initialized, lets run the examples 1 by 1
		Set<String> samplesSet = examples.getExampleSet();
		for (String sampleName : samplesSet){
			Example example = examples.getExample(sampleName);

			if(!example.shouldRun){
				continue;
			}

			System.out.println("**************************************************************************************************************");
			System.out.println(String.format("Running Example %s", sampleName));
			System.out.println("**************************************************************************************************************\n\n");

			// Creating Input Resources and uploading related files
			//-------------------------------------------------------------------------------------------
			// Note - the different input resources can be created and uploaded in parallel without order importance.


			// Create VDP Template input resource, upload its file (hpd), and wait for it to turn to ready state.
			//=================================================================================================
			System.out.println("Create VDP Template input resource, upload its file (hpd), and wait for it to turn to ready state...");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

			System.out.println("Create Template Input Resource");
			System.out.println("--------------------------------------------------------");
			TemplateResourceCreation templateResourceCreation = example.vdpTemplate.toTemplateResourceCreation();
			TemplateResource templateResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/template" ,
					templateResourceCreation, TemplateResource.class, 201);

			System.out.println("Uploading template file (hpd)");
			System.out.println("--------------------------------------------------------");
			// Upload hpd file
			AssetUploader assetUploader = new AssetUploader(
					templateResource.getOutput().getResourceId(),
					SampleFileLoader.getFilePath(example.vdpTemplate.fileName),
					ResourceType.Template);
			assetUploader.upload();

			System.out.println("Wait until template resource gets to ready state");
			System.out.println("--------------------------------------------------------");
			// wait until status change to Ready
			while(!templateResource.getOutput().getStatus().equals("Ready") && !templateResource.getOutput().getStatus().equals("Error")){
				templateResource = Client.httpCall("GET", Configuration.apiBaseUrl,"/composer/sdk/v1/template" + "/" + templateResource.getOutput().getResourceId(),
						null, TemplateResource.class, 200);
				if(!templateResource.getOutput().getStatus().equals("Ready") && !templateResource.getOutput().getStatus().equals("Error")){
					sleepForTenSeconds();
				}
			}

			if(templateResource.getOutput().getStatus().equals("Error")){
				return;
			}

			String templateResourceId = templateResource.getOutput().getResourceId();
			System.out.println("--------------------------------------------------------\n\n");


			// Create Data input resource, upload its file (csv or txt), and wait for it to turn to ready state.
			//=================================================================================================
			System.out.println("Create Data input resource, upload its file (csv or txt), and wait for it to turn to ready state...");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

			System.out.println("Create Data Input Resource");
			System.out.println("--------------------------------------------------------");
			DataResourceCreation dataResourceCreation = example.data.toDataResourceCreation();
			DataResource dataResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/data" ,
					dataResourceCreation, DataResource.class, 201);

			System.out.println("Uploading data file (txt or csv)");
			System.out.println("--------------------------------------------------------");
			// Upload data file (csv or txt)
			assetUploader = new AssetUploader(
					dataResource.getOutput().getResourceId(),
					SampleFileLoader.getFilePath(example.data.fileName),
					ResourceType.Data);
			assetUploader.upload();

			System.out.println("Wait until data resource gets to ready state");
			System.out.println("--------------------------------------------------------");
			// wait until status change to Ready
			while(!dataResource.getOutput().getStatus().equals("Ready") && !dataResource.getOutput().getStatus().equals("Error")){
				dataResource = Client.httpCall("GET", Configuration.apiBaseUrl,"/composer/sdk/v1/data" + "/" + dataResource.getOutput().getResourceId(),
						null, DataResource.class, 200);
				if(!dataResource.getOutput().getStatus().equals("Ready") && !dataResource.getOutput().getStatus().equals("Error")){
					sleepForTenSeconds();
				}
			}

			if(dataResource.getOutput().getStatus().equals("Error")){
				return;
			}
			String dataResourceId = dataResource.getOutput().getResourceId();
			System.out.println("--------------------------------------------------------\n\n");


			// Create Imposition Template input resource, upload its file (impp), and wait for it to turn to ready state.
			//=================================================================================================
			String impositionTemplateResourceId = null;
			if(example.impositionTemplate != null) { // not must
				System.out.println("Create Imposition Template input resource, upload its file (impp), and wait for it to turn to ready state...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				System.out.println("Create Imposition Template Resource");
				System.out.println("--------------------------------------------------------");
				ImpositionTemplateResourceCreation impositionTemplateResourceCreation = example.impositionTemplate.toImpositionTemplateResourceCreation();

				ImpositionTemplateResource impositionTemplateResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/imposition",
						impositionTemplateResourceCreation, ImpositionTemplateResource.class, 201);

				System.out.println("Uploading imposition template file (impp)");
				System.out.println("--------------------------------------------------------");
				// Upload Imposition Template file (impp)
				assetUploader = new AssetUploader(
						impositionTemplateResource.getOutput().getResourceId(),
						SampleFileLoader.getFilePath(example.impositionTemplate.fileName),
						ResourceType.ImpositionTemplate);
				assetUploader.upload();

				System.out.println("Wait until imposition template resource gets to ready state");
				System.out.println("--------------------------------------------------------");
				// wait until status change to Ready
				while (!impositionTemplateResource.getOutput().getStatus().equals("Ready") && !impositionTemplateResource.getOutput().getStatus().equals("Error")) {
					impositionTemplateResource = Client.httpCall("GET", Configuration.apiBaseUrl, "/composer/sdk/v1/imposition" + "/" + impositionTemplateResource.getOutput().getResourceId(),
							null, ImpositionTemplateResource.class, 200);
					if (!impositionTemplateResource.getOutput().getStatus().equals("Ready") && !impositionTemplateResource.getOutput().getStatus().equals("Error")) {
						sleepForTenSeconds();
					}
				}

				if (impositionTemplateResource.getOutput().getStatus().equals("Error")) {
					return;
				}
				impositionTemplateResourceId = impositionTemplateResource.getOutput().getResourceId();
			}
			System.out.println("--------------------------------------------------------\n\n");

			// Create Assets Library input resource, upload its file (impp), and wait for it to turn to ready state.
			//=================================================================================================
			String assetsLibraryResourceId = null;
			if(example.assetsLibrary != null) { // not must
				System.out.println("Create Assets Library input resource, upload its file (zip), and wait for it to turn to ready state...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				System.out.println("Create Assets Library Resource");
				System.out.println("--------------------------------------------------------");
				AssetsLibraryResourceCreation assetsLibraryResourceCreation = example.assetsLibrary.toAssetsLibraryCreation();

				AssetsLibraryResource assetsLibraryResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/assetslibrary",
						assetsLibraryResourceCreation, AssetsLibraryResource.class, 201);

				System.out.println("Uploading assets library file (zip)");
				System.out.println("--------------------------------------------------------");
				// Upload Assets Library file (impp)
				assetUploader = new AssetUploader(
						assetsLibraryResource.getOutput().getResourceId(),
						SampleFileLoader.getFilePath(example.assetsLibrary.fileName),
						ResourceType.AssetsLibrary);
				assetUploader.upload();

				System.out.println("Wait until assets library resource gets to ready state");
				System.out.println("--------------------------------------------------------");
				// wait until status change to Ready
				while (!assetsLibraryResource.getOutput().getStatus().equals("Ready") && !assetsLibraryResource.getOutput().getStatus().equals("Error")) {
					assetsLibraryResource = Client.httpCall("GET", Configuration.apiBaseUrl, "/composer/sdk/v1/assetslibrary" + "/" + assetsLibraryResource.getOutput().getResourceId(),
							null, AssetsLibraryResource.class, 200);
					if (!assetsLibraryResource.getOutput().getStatus().equals("Ready") && !assetsLibraryResource.getOutput().getStatus().equals("Error")) {
						sleepForTenSeconds();
					}
				}

				if (assetsLibraryResource.getOutput().getStatus().equals("Error")) {
					return;
				}
				assetsLibraryResourceId = assetsLibraryResource.getOutput().getResourceId();
			}
			System.out.println("--------------------------------------------------------\n\n");



			// Creating Output Resources
			//-------------------------------------------------------------------------------------------
			// Note - the different output resources can be created in parallel without order importance.




			// Create output Sample Resource, and wait for it to turn to ready state
			//=================================================================================================
			String sampleResourceId = null;
			if(example.sampleOutput != null) {
				System.out.println("Create output Sample Resource, and wait for it to turn to ready state...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				System.out.println("Create Sample Resource");
				System.out.println("--------------------------------------------------------");
				SampleResourceCreation sampleResourceCreation = example.sampleOutput.toSampleResourceCreation(templateResourceId, dataResourceId, impositionTemplateResourceId, assetsLibraryResourceId);

				SampleResource sampleResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/sample",
						sampleResourceCreation, SampleResource.class, 201);

				System.out.println("Wait until Sample resource gets to ready state");
				System.out.println("--------------------------------------------------------");
				// wait until status change to Ready
				while (!sampleResource.getOutput().getStatus().equals("Ready") && !sampleResource.getOutput().getStatus().equals("Error")) {
					sampleResource = Client.httpCall("GET", Configuration.apiBaseUrl, "/composer/sdk/v1/sample/" + sampleResource.getOutput().getResourceId(),
							null, SampleResource.class, 200);
					if (!sampleResource.getOutput().getStatus().equals("Ready") && !sampleResource.getOutput().getStatus().equals("Error")) {
						sleepForTenSeconds();
					}
				}

				if (sampleResource.getOutput().getStatus().equals("Error")) {
					return;
				}

				sampleResourceId = sampleResource.getOutput().getResourceId();
				System.out.println("--------------------------------------------------------\n\n");
			}


			// Create full PDF output Resource, and wait for it to turn to ready state
			//=================================================================================================
			String pdfResourceId = null;
			if(example.pdfOutput != null) {
				System.out.println("Create PDF output Resource, and wait for it to turn to ready state...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				System.out.println("Create PDF Resource");
				System.out.println("--------------------------------------------------------");
				PdfResourceCreation pdfResourceCreation = example.pdfOutput.toPdfResourceCreation(templateResourceId, dataResourceId, impositionTemplateResourceId, assetsLibraryResourceId);
				PdfResource pdfResource = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/pdf", pdfResourceCreation ,PdfResource.class, 201);

				System.out.println("Wait until PDF resource gets to ready state");
				System.out.println("--------------------------------------------------------");
				// wait until status change to Ready
				while (!pdfResource.getOutput().getStatus().equals("Ready") && !pdfResource.getOutput().getStatus().equals("Error")) {
					pdfResource = Client.httpCall("GET", Configuration.apiBaseUrl, "/composer/sdk/v1/pdf/" + pdfResource.getOutput().getResourceId(),
							null, PdfResource.class, 200);
					if (!pdfResource.getOutput().getStatus().equals("Ready") && !pdfResource.getOutput().getStatus().equals("Error")) {
						sleepForTenSeconds();
					}
				}

				if (pdfResource.getOutput().getStatus().equals("Error")) {
					return;
				}


				pdfResourceId = pdfResource.getOutput().getResourceId();
				System.out.println("--------------------------------------------------------\n\n");
			}



			// Touch Resource Lifespan - note - this example contain single resource ID per call
			//======================================================================================
			if(example.shouldTouch) {
				System.out.println("Touch Resources Lifespan...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				{ // Touch Template input resource
					System.out.println("Touch Template input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(templateResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/template/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}


				{ // Touch Data input resource
					System.out.println("Touch Data input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(dataResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/data/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}


				if (impositionTemplateResourceId != null){ // touch imposition template Input Resource
					System.out.println("Touch Imposition Template input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(impositionTemplateResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/imposition/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}

				if (assetsLibraryResourceId != null){ // touch assets library Input Resource
					System.out.println("Touch Assets Library input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(assetsLibraryResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/assetslibrary/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}



				if (sampleResourceId != null) { // touch Sample Output Resource
					System.out.println("Touch Sample output resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(sampleResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/sample/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}


				if (pdfResourceId != null) { // touch Pdf output resource
					System.out.println("Touch PDF output resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(pdfResourceId);
					resourceIdCollection.setResourceIds(resourceIds);
					LifespanCollection lifespanCollection = Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/pdf/lifespan",
							resourceIdCollection, LifespanCollection.class, 200);

					System.out.println("--------------------------------------------------------\n");
				}
			}

			// Delete Resource - note - this example contain single resource ID per call
			//==============================================================================
			if(example.shouldDelete) {
				System.out.println("Delete Resources...");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

				{ // Delete Template input resource
					System.out.println("Delete Template input resource");
					System.out.println("--------------------------------------------------------");
					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(templateResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/template/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}

				{ // Delete Data input resource
					System.out.println("Delete Data input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(dataResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/data/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}

				if (impositionTemplateResourceId != null) { // Delete Imposition Template input resource
					System.out.println("Delete Imposition Template input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(impositionTemplateResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/imposition/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}

				if (assetsLibraryResourceId != null) { // Delete Imposition Template input resource
					System.out.println("Delete Assets Library input resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(assetsLibraryResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/assetslibrary/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}

				if (sampleResourceId != null) { // Delete Sample output resource
					System.out.println("Delete Sample output resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(sampleResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/sample/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}

				if (pdfResourceId != null) { // Delete Pdf output resource
					System.out.println("Delete PDF output resource");
					System.out.println("--------------------------------------------------------");

					ResourceIdCollection resourceIdCollection = new ResourceIdCollection();
					List<String> resourceIds = new ArrayList<>();
					resourceIds.add(pdfResourceId);
					resourceIdCollection.setResourceIds(resourceIds);

					Client.httpCall("POST", Configuration.apiBaseUrl, "/composer/sdk/v1/pdf/delete",
							resourceIdCollection, null, 204);

					System.out.println("--------------------------------------------------------");
				}
			}
		}
	}




	private static void  sleepForTenSeconds(){
		try {
			Thread.sleep(2000);
		}catch (Throwable throwable){

		}
	}


	private static Boolean processCommandLine(String[] args){

		Boolean success = true;

		if(args == null || args.length < 2){
			success = false;

		}else{
			Configuration.hmacKey = args[0];
			Configuration.hmacSecret = args[1];
			if(args.length > 2){
				try{
					Configuration.useProxyForPartsUpload = Configuration.useProxy = Boolean.parseBoolean(args[2]);

					if(Configuration.useProxy){
						if(args.length >= 5){
							Configuration.proxyHost = args[3];

							Configuration.proxyPort = Integer.parseInt(args[4]);
							if(args.length == 6){
								Configuration.useProxyForPartsUpload = Boolean.parseBoolean(args[5]);
							}

						}else{
							success = false;
						}
					}

				}catch (Throwable throwable){
					success = false;
				}
			}else{
				Configuration.useProxyForPartsUpload = Configuration.useProxy = false;
			}
		}

		if(!success){
			printoutCommandLineRequirements();
		}

		return success;
	}

	private static void printoutCommandLineRequirements(){
		System.out.println("Missing commandline inputs: java composer-sdk-sample-code.jar <hmacKey> <hmacSecret> [useProxy] [proxyHost] [proxyPort]");
		System.out.println("hmacKey - hmac key generated by PrintOS");
		System.out.println("hmacSecret - hmac secret generated by PrintOS");
		System.out.println("useProxy - not must. can get \"true\" or \"false\". if not suppled assume false.");
		System.out.println("proxyHost - if useProxy is true, then this value is a must - should contain the proxy host name");
		System.out.println("proxyPort - if useProxy is true, then this value is a must - should contain the proxy port number");
	}
}
