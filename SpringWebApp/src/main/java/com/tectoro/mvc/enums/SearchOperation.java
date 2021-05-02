package com.tectoro.mvc.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SearchOperation {
	
	EQUAL_TO("="),NOT_EQUAL_TO("!="),CONTAINS("%"),STARTS_WITH("_*"),ENDS_WITH("*_"),
	GREATER_THAN(">"),GREATER_THAN_OR_EQUAL_TO(">="),LESS_THAN("<"),LESS_THAN_OR_EQUAL_TO("<=");
	
	private String field;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	SearchOperation(String string) {
		this.field = string;
	}
	
	public static List<String> getTextFiledOperations()	{
		String[] arr = {EQUAL_TO.name(),NOT_EQUAL_TO.name(),CONTAINS.name(),STARTS_WITH.name(),ENDS_WITH.name()};
		 return Arrays.stream(arr).collect(Collectors.toList());
	}
	
	public static List<String> getDropdownOperations()	{
		String[] arr = {EQUAL_TO.name(),NOT_EQUAL_TO.name()};
		return Arrays.stream(arr).collect(Collectors.toList());
	}
	
	public static List<String> getNumberFieldOperations()	{
		String[] arr = {EQUAL_TO.name(),NOT_EQUAL_TO.name(),GREATER_THAN.name(),
				GREATER_THAN_OR_EQUAL_TO.name(),LESS_THAN.name(),LESS_THAN_OR_EQUAL_TO.name()};
		return Arrays.stream(arr).collect(Collectors.toList());
	}
}
