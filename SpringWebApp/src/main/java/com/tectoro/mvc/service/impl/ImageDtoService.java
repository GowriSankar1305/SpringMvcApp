package com.tectoro.mvc.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.ImageDao;
import com.tectoro.mvc.dto.ImageDto;
import com.tectoro.mvc.entity.Image;
import com.tectoro.mvc.enums.ImageEnum;
import com.tectoro.mvc.service.ImageService;

@Service
public class ImageDtoService implements ImageService {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageDtoService.class);
	
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public ImageDto saveOrUpdateImage(ImageDto imageDto) {
		logger.info("<============== Start of ImageDtoService.saveOrUpdateImage =============>");
		Image image = convertDtoToEntity.apply(imageDto);
		image.setUpdatedDate(LocalDateTime.now());
		image = imageDao.saveImage(image);
		logger.info("<============== Start of ImageDtoService.saveOrUpdateImage =============>");
		return convertEntityToDto.apply(image);
	}

	@Override
	public ImageDto getImageById(Long imageId) {
		Image image = imageDao.getImageById(imageId);
		return convertEntityToDto.apply(image);
	}

	@Override
	public List<ImageDto> getHotelsImagesById(Long hotelId) {
		List<ImageDto> imageDtoList = null;
		List<Image> imagesList = imageDao.getHotelImagesById(hotelId);
		if(!CollectionUtils.isEmpty(imagesList))	{
			imageDtoList = imagesList.stream().map(convertEntityToDto).collect(Collectors.toList());
		}
		return imageDtoList;
	}

	@Override
	public List<ImageDto> getRoomImagesById(Long roomId) {
		List<ImageDto> imageDtoList = null;
		List<Image> imagesList = imageDao.getRoomImagesById(roomId);
		if(!CollectionUtils.isEmpty(imagesList))	{
			imageDtoList = imagesList.stream().map(convertEntityToDto).collect(Collectors.toList());
		}
		return imageDtoList;
	}
	
	public static Function<ImageDto, Image> convertDtoToEntity = dto -> {
		Image image = new Image();
		image.setCustomerId(dto.getCustomerId());
		image.setFileExtension(dto.getFileExtension());
		image.setHotelId(dto.getHotelId());
		image.setImageId(dto.getImageId());
		image.setImagePath(dto.getImagePath());
		image.setImageSize(dto.getImageSize());
		image.setImageType(ImageEnum.valueOf(dto.getImageType()));
		image.setIsDeleted(dto.getIsDeleted());
		image.setMimeType(dto.getMimeType());
		image.setOriginalFileName(dto.getOriginalFileName());
		image.setGeneratedFileName(dto.getGeneratedFileName());
		image.setRoomId(dto.getRoomId());
		image.setStaffId(dto.getStaffId());
		image.setCreatedDate(dto.getCreatedDate());
		image.setAdminId(dto.getAdminId());
		return image;
	};
	
	public static Function<Image, ImageDto> convertEntityToDto = entity -> {
		ImageDto dto = null;
		if(null != entity)	{
			dto = new ImageDto();
			dto.setCreatedDate(entity.getCreatedDate());
			dto.setCustomerId(entity.getCustomerId());
			dto.setFileExtension(entity.getFileExtension());
			dto.setGeneratedFileName(entity.getGeneratedFileName());
			dto.setHotelId(entity.getHotelId());
			dto.setImageId(entity.getImageId());
			dto.setImagePath(entity.getImagePath());
			dto.setImageSize(entity.getImageSize());
			dto.setImageType(entity.getImageType().name());
			dto.setIsDeleted(entity.getIsDeleted());
			dto.setStaffId(entity.getStaffId());
			dto.setRoomId(entity.getRoomId());
			dto.setOriginalFileName(entity.getOriginalFileName());
			dto.setMimeType(entity.getMimeType());
			dto.setAdminId(entity.getAdminId());
		}
		return dto;
	};
}
