package com.hp.composer.sdk.api.v1.helpers;

import com.hp.composer.sdk.api.v1.configuration.Configuration;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hmac {
	public Hmac(String method, String path){
		this.hmacDate = getUtcDatetimeAsString();
		this.hmacAlgorithm = Configuration.hmacAlgorithm;
		this.method = method;
		this.path = path;
	}

	private String hmacKey;
	private String hmacSecret;

	private String hmacAuthentication;
	private String hmacDate;
	private String hmacAlgorithm;

	String method;
	String path;

	public String getHmacKey() {
		return hmacKey;
	}

	public String getHmacSecret() {
		return hmacSecret;
	}

	public String getHmacAuthentication() {
		return hmacAuthentication;
	}

	public String getHmacDate() {
		return hmacDate;
	}

	public String getHmacAlgorithm() {
		return hmacAlgorithm;
	}

	public void generateHmacAuthentication() throws InvalidKeyException, NoSuchAlgorithmException {
		hmacKey = Configuration.hmacKey;
		hmacSecret = Configuration.hmacSecret;

		SecretKeySpec secret_key = new SecretKeySpec(hmacSecret.getBytes(), Configuration.javaxCryptoName);
		Mac mac = Mac.getInstance(Configuration.javaxCryptoName);
		mac.init(secret_key);

		String toHash = method + " " + path + hmacDate;
		byte[] rawHmac = mac.doFinal(toHash.getBytes());
		StringBuilder hash = new StringBuilder();
		for (byte b : rawHmac) {
			hash.append(String.format("%02x", b & 0xff));
		}

		hmacAuthentication = hmacKey + ":" + hash.toString();
	}

	private static String getUtcDatetimeAsString(){
		final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";// e.g.: 2016-04-15T12:00:00.000Z
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		final String utcTime = sdf.format(new Date());
		return utcTime;
	}
}
