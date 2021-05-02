package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.ImageDto;

public interface ImageService {
	public ImageDto saveOrUpdateImage(ImageDto imageDto);
	public ImageDto getImageById(Long imageId);
	public List<ImageDto> getHotelsImagesById(Long hotelId);
	public List<ImageDto> getRoomImagesById(Long roomId);
}
