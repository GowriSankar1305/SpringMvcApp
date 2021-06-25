package com.tectoro.mvc.dao;

import java.util.List;

import com.tectoro.mvc.entity.RoomType;

public interface RoomTypeDao {
	public List<RoomType> getAllRoomTypes();
	public RoomType saveRoomType(RoomType roomType);
}
