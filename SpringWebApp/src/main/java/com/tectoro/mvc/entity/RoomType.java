package com.tectoro.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_room_type")
public class RoomType {
	
	@Id
	@Column(name = "room_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomTypeId;
	@Column(name = "room_type_name")
	private String roomTypeName;
	
	public Long getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
}
