package com.tectoro.mvc.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tectoro.mvc.dao.RoomTypeDao;
import com.tectoro.mvc.dto.RoomTypeDto;
import com.tectoro.mvc.entity.RoomType;
import com.tectoro.mvc.service.RoomTypeService;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	
	@Autowired
	private RoomTypeDao roomTypeDao;
	
	@Override
	public List<RoomTypeDto> getAllRoomTypes() {
		List<RoomType> roomTypes = roomTypeDao.getAllRoomTypes();
		if(CollectionUtils.isEmpty(roomTypes))	{
			return null;
		}
		return roomTypes.stream().map(convertEntityToDto).collect(Collectors.toList());
	}
	
	private static Function<RoomType, RoomTypeDto> convertEntityToDto = entity -> {
		RoomTypeDto dto = null;
		if(null != entity)	{
			dto = new RoomTypeDto();
			dto.setRoomTypeId(entity.getRoomTypeId());
			dto.setRoomTypeName(entity.getRoomTypeName());
		}
		return dto;
	};

	@Override
	public RoomTypeDto saveRoomType(RoomTypeDto roomTypeDto) {
		RoomType roomType = new RoomType();
		roomType.setRoomTypeName(roomTypeDto.getRoomTypeName());
		roomType = roomTypeDao.saveRoomType(roomType);
		return convertEntityToDto.apply(roomType);
	}
}
