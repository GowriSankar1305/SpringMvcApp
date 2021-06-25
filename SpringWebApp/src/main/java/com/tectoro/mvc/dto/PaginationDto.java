package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationDto implements Serializable {

	private static final long serialVersionUID = 946988873742358342L;
	
	private int pageNumber;
	private String commaSeparatedIds;
	private boolean isActive;
	
	public PaginationDto(int pageNumber, String commaSeparatedIds,boolean isActive) {
		this.pageNumber = pageNumber;
		this.commaSeparatedIds = commaSeparatedIds;
		this.isActive =isActive;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getCommaSeparatedIds() {
		return commaSeparatedIds;
	}
	public void setCommaSeparatedIds(String commaSeparatedIds) {
		this.commaSeparatedIds = commaSeparatedIds;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "PaginationDto [pageNumber=" + pageNumber + ", commaSeparatedIds=" + commaSeparatedIds + ", isActive="
				+ isActive + "]";
	}
}
