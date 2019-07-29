//Copyright 2019 HP Inc.
package com.hp.composer.sdk.api.v1.configuration;


public class Configuration {

	public static Boolean useProxy = false;
	public static Boolean useProxyForPartsUpload  = false;
	public static String proxyHost;
	public static int proxyPort;

	public static String apiBaseUrl = "https://printos.api.hp.com/composer-service";

	public static String xHpHmacAuthentication = "x-hp-hmac-authentication";
	public static String xHpHmacDate = "x-hp-hmac-date";
	public static String xHpHmacAlgorithm = "x-hp-hmac-algorithm";

	//Enter your PrintOS Composer Key here...
	public static String hmacKey;
	//Enter your PrintOS Composer Secret here...
	public static String hmacSecret;
	public static String hmacAlgorithm = "SHA1";
	public static String javaxCryptoName = "HmacSHA1";

	public static Long partSizeInBytes = 5242880L; // this is the minimum part size allowed - you can have it bigger.


}
