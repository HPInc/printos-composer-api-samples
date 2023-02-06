package com.hp.composer.sdk.api.v1.resources.common;

import com.hp.composer.sdk.api.v1.helpers.CollectionToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LifespanCollection extends CollectionToString<String> {
	public LifespanCollection(){}

	private List<String> resourceIds;
	private Long newExpirationTime;

	public List<String> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(List<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public Long getNewExpirationTime() {
		return newExpirationTime;
	}

	public void setNewExpirationTime(Long newExpirationTime) {
		this.newExpirationTime = newExpirationTime;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("LifespanCollection:{");
		stringBuilder.append("newExpirationTime:").append(newExpirationTime).append(", ");
		stringBuilder.append(collectionToString(resourceIds, "resourceIds", "resourceId"));
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
