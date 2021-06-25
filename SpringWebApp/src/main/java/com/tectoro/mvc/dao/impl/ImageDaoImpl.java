package com.tectoro.mvc.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.ImageDao;
import com.tectoro.mvc.entity.Image;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class ImageDaoImpl implements ImageDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public Image saveImage(Image image) {
		return hibernateUtils.saveOrUpdateEntity(image);
	}

	@Override
	public Image getImageById(Long imageId) {
		return hibernateUtils.findEntityByPrimaryId(Image.class, imageId);
	}

	@Override
	public List<Image> getHotelImagesById(Long hotelId) {
		Map<String, Serializable> columns = new HashMap<>();
		columns.put("hotelId", hotelId);
		return hibernateUtils.loadEntitiesBsdOnSearchCriteria(Image.class, columns);
	}

	@Override
	public List<Image> getRoomImagesById(Long roomId) {
		Map<String, Serializable> columns = new HashMap<>();
		columns.put("roomId", roomId);
		return hibernateUtils.loadEntitiesBsdOnSearchCriteria(Image.class, columns);
	}

	@Override
	public Image getImageByAdminId(long adminId) {
		return hibernateUtils.findEntityByUniqueProperty(Image.class, "adminId", adminId);
	}

}
