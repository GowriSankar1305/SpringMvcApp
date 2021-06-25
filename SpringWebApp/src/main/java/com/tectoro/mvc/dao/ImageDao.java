package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.Image;

public interface ImageDao {
	public Image saveImage(Image image);
	public Image getImageById(Long imageId);
	public List<Image> getHotelImagesById(Long hotelId);
	public List<Image> getRoomImagesById(Long roomId);
	public Image getImageByAdminId(long adminId);
}
