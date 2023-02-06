package com.hp.composer.sdk.api.v1.resources.output.sample;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum RequiredObjectType {
	ImposedSpread,
	NonImposedPageRecord
}
