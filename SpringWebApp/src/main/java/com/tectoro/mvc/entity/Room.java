package com.tectoro.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_room")
public class Room {
	
	@Id
	@Column(name = "room_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	@Column(name = "room_code")
	private String roomCode;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	private RoomType roomType;
	@Column(name = "no_of_beds")
	private Integer noOfBeds;
	@Column(name = "no_of_persons")
	private Integer noOfPersons;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	@Column(name = "comments")
	private String comments;
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public Integer getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(Integer noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public Integer getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
