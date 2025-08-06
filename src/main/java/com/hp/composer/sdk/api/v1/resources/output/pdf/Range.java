package com.hp.composer.sdk.api.v1.resources.output.pdf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Range {
	public Range(){}

	private Integer from;
	private Integer to;

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Range:{");
		stringBuilder.append("from:").append(from).append(", ");
		stringBuilder.append("to:").append(to).append(", ");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
}
