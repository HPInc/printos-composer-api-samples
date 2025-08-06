package com.hp.composer.sdk.api.v1.helpers;

import com.hp.composer.sdk.api.v1.configuration.Configuration;
import com.hp.composer.sdk.api.v1.resources.common.SmsException;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class Client{
	private Client(){}


	public static <ResponsePayload> ResponsePayload httpCall(String method, String baseUrl, String relativeUrl,
															 Object requestPayload, Class<ResponsePayload> responsePayloadType, Integer expectSuccessCode){

		String fullUrl = baseUrl + relativeUrl;

		System.out.println(String.format("%s on %s\n", method, fullUrl));

		if(requestPayload != null) {
			System.out.println(String.format("Request Payload: \n%s\n", NiceJson.toJson(requestPayload)));
		}

		Response response = null;
		try {
			Hmac hmac = new Hmac(method, relativeUrl);
			hmac.generateHmacAuthentication();

			ResteasyClientBuilder client = RestClientBuilder.getRestClientBuilder();
			ResteasyWebTarget target = client.build().target(baseUrl + relativeUrl);

			Invocation.Builder builder;

			if(responsePayloadType != null){
				builder = target.request().accept("application/json");
			}else{
				builder = target.request();
			}

			builder = builder.
					header(Configuration.xHpHmacAuthentication, hmac.getHmacAuthentication()).
					header(Configuration.xHpHmacAlgorithm, hmac.getHmacAlgorithm()).
					header(Configuration.xHpHmacDate, hmac.getHmacDate());


			if(requestPayload != null){
				response = builder.method(method, Entity.entity(requestPayload, "application/json"));
			}else{
				response = builder.method(method);
			}



			if(response != null && response.getStatusInfo() != null && response.getStatusInfo().getStatusCode() == expectSuccessCode){
				String responseMessage = null;

				if(responsePayloadType != null){

					ResponsePayload responsePayload = response.readEntity(responsePayloadType);

					if(responsePayload == null){
						String errorMessage = "empty response\n\n";
						System.out.println(errorMessage);
						throw new RuntimeException(errorMessage);
					}


					System.out.println(String.format("Response Payload: \n%s\n\n", NiceJson.toJson(responsePayload)));

					return responsePayload;
				}else{
					return null;
				}

			}else{
				throw checkErrorResponse(response);
			}
		}catch (Throwable throwable){
			String errorMessage = String.format("encountered with exception %s\n\n", throwable);
			System.out.println(errorMessage);
			throw new RuntimeException(errorMessage);
		}finally {
			if(response != null){
				response.close();
			}
		}
	}

	private static RuntimeException checkErrorResponse(Response response){
		if(response != null){
			try {
				SmsException smsException = response.readEntity(SmsException.class);
				String errorMessage = String.format("\nError http call response smsException:\n%s", NiceJson.toJson(smsException));
				System.out.println(errorMessage);
				return new RuntimeException(errorMessage);
			}catch (Throwable throwable){
				try {
					String output = response.readEntity(String.class);
					String errorMessage = String.format("\nError http call response code %s output text:\n%s", response.getStatusInfo().getStatusCode(), output);
					return new RuntimeException(errorMessage);
				}catch (Throwable throwable1){
					String errorMessage = String.format("\nError http call response code %s ", response.getStatusInfo().getStatusCode());
					return new RuntimeException(errorMessage);
				}
			}
		}else{
			System.out.println("Error http call Error Response");
			return new RuntimeException("Error http call Error Response");
		}
	}


}
