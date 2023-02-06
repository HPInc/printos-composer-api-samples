package com.hp.composer.sdk.api.v1.helpers;

import org.codehaus.jackson.map.ObjectMapper;

public class NiceJson {

	public static String toJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Throwable throwable) {
			throw new RuntimeException(throwable.getMessage());
		}
	}

	public static <C> C fromJsonResponse(String response, Class<C> javaType) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(response, javaType);
		}catch (Throwable throwable){
			throw new RuntimeException(throwable.getMessage());
		}
	}
}
