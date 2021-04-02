package com.tectoro.mvc.enums;

public enum DateFormatEnum {
	
	YYYY_MM_DD("yyyy-MM-dd");
	
	private String field;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	DateFormatEnum(String string) {
		this.field = string;
	}
}
