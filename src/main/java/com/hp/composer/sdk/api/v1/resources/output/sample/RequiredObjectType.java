package com.hp.composer.sdk.api.v1.resources.output.sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum RequiredObjectType {
	ImposedSpread,
	NonImposedPageRecord
}
