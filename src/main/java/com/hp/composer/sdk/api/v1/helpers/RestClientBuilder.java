package com.hp.composer.sdk.api.v1.helpers;

import com.hp.composer.sdk.api.v1.configuration.Configuration;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.net.ssl.SSLContext;
import java.util.concurrent.TimeUnit;

public class RestClientBuilder {

	public static ResteasyClientBuilder getRestClientBuilder() {
		return getRestClientBuilder(null);
	}

	public static ResteasyClientBuilder getRestClientBuilder(Boolean withProxy) {
		String methodName = "RestClientBuilder.getRestClientBuilder";

		Boolean useProxy = withProxy == null ? Configuration.useProxy : withProxy;

		try {
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			sslContext.init(null, null, null);

			ResteasyClientBuilder clientBuilder = new ResteasyClientBuilder()
					.sslContext(sslContext)
					.disableTrustManager()
					.register(JacksonJsonProvider.class)
					.establishConnectionTimeout(100, TimeUnit.SECONDS)
					.socketTimeout(10, TimeUnit.SECONDS);

			if (useProxy) {
				clientBuilder.defaultProxy(Configuration.proxyHost, Configuration.proxyPort, "http");
			}

			return clientBuilder;

		} catch (Throwable throwable) {
			System.out.println(String.format("%s encountered exception %s", methodName, throwable));
			return null;
		}
	}
}
