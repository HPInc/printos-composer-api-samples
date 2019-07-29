//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.helpers;

import java.util.List;

public abstract class CollectionToString<T> {

	public String collectionToString(List<T> collection, String collectionName, String itemName){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(collectionName).append(":{");
		if(collection != null){
			stringBuilder.append("[");
			if(collection.size() > 0){
				for (T t: collection) {
					stringBuilder.append(itemName).append(":").append(t.toString());
				}
			}
			stringBuilder.append("]");
		}else{
			stringBuilder.append(itemName).append("=").append("null");
		}

		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
