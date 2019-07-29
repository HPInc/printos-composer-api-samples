//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.resources.common;

import com.hp.composer.sdk.api.v1.helpers.CollectionToString;
import java.util.List;

public class ResourceIdCollection extends CollectionToString<String> {
	public ResourceIdCollection(){}

	private List<String> resourceIds;

	public List<String> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(List<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	@Override
	public String toString(){
		return collectionToString(resourceIds, "resourceIds", "resourceId");
	}
}
