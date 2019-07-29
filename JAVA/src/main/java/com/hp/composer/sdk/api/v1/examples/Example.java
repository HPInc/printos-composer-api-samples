//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.examples;


public class Example {
	public Example(Boolean shouldRun, VdpTemplate vdpTemplate, Data data,
				   ImpositionTemplate impositionTemplate, AssetsLibrary assetsLibrary ,SampleOutput sampleOutput, PdfOutput pdfOutput, Boolean shouldTouch, Boolean shouldDelete){
		this.vdpTemplate = vdpTemplate;
		this.data = data;
		this.impositionTemplate = impositionTemplate;
		this.assetsLibrary = assetsLibrary;
		this.sampleOutput = sampleOutput;
		this.pdfOutput = pdfOutput;
		this.shouldRun = shouldRun;
		this.shouldTouch = shouldTouch;
		this.shouldDelete = shouldDelete;
	}


	public Boolean shouldRun;
	public VdpTemplate vdpTemplate;
	public Data data;
	public ImpositionTemplate impositionTemplate;
	public AssetsLibrary assetsLibrary;
	public SampleOutput sampleOutput;
	public PdfOutput pdfOutput;
	public Boolean shouldTouch;
	public Boolean shouldDelete;



}
