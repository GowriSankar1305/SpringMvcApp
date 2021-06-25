package com.tectoro.mvc.service;

import java.util.List;

import com.tectoro.mvc.dto.RoomTypeDto;

public interface RoomTypeService {
	public RoomTypeDto saveRoomType(RoomTypeDto roomTypeDto);
	public List<RoomTypeDto> getAllRoomTypes();
}
