//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.helpers;

import com.hp.composer.sdk.api.v1.configuration.Configuration;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import javax.net.ssl.SSLContext;
import java.util.concurrent.TimeUnit;

public class RestClientBuilder {

	public static ResteasyClientBuilder getRestClientBuilder(){
		return getRestClientBuilder(null);
	}

	public static ResteasyClientBuilder getRestClientBuilder(Boolean withProxy){
		String methodName = "RestClientBuilder.getRestClientBuilder";

		Boolean useProxy = withProxy == null ? Configuration.useProxy : withProxy;

		try{
			ResteasyClientBuilder clientBuilder = new ResteasyClientBuilder();
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			sslContext.init(null, null, null);

			clientBuilder.sslContext(sslContext);
			clientBuilder.disableTrustManager();
			clientBuilder.establishConnectionTimeout(100, TimeUnit.SECONDS);
			clientBuilder.socketTimeout(10, TimeUnit.SECONDS);

			if(useProxy){
				clientBuilder.defaultProxy(Configuration.proxyHost, Configuration.proxyPort,"http");
			}



			return clientBuilder;
		}catch (Throwable throwable){
			System.out.println(String.format("%s encountered exception %s",methodName, throwable));
			return null;
		}

	}


}
