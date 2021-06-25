package com.tectoro.mvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tectoro.mvc.dao.RoomTypeDao;
import com.tectoro.mvc.entity.RoomType;
import com.tectoro.mvc.utils.HibernateUtils;

@Repository
public class RoomTypeDaoImpl implements RoomTypeDao {
	
	@Autowired
	private HibernateUtils hibernateUtils;
	
	@Override
	public List<RoomType> getAllRoomTypes() {
		return hibernateUtils.loadEntities(RoomType.class);
	}

	@Override
	public RoomType saveRoomType(RoomType roomType) {
		return hibernateUtils.saveEntity(roomType);
	}
}
