package com.tectoro.mvc.utils;

public interface CommonInterface {
	public <R, T> T convertDtoToEntity(R dto,T entity);
	public <T, R> R convertEntityToDto(T entity,R dto);
}
