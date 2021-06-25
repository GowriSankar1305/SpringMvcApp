package com.tectoro.mvc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomTypeDto implements Serializable {
	
	private static final long serialVersionUID = -2743211733845358473L;
	
	private Integer roomTypeId;
	private String roomTypeName;
	
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	
	@Override
	public String toString() {
		return "RoomTypeDto [roomTypeId=" + roomTypeId + ", roomTypeName=" + roomTypeName + "]";
	}
}
