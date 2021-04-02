package com.tectoro.mvc.entity;

import java.time.LocalDateTime;

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
@Table(name = "tbl_blocked_room")
public class BlockedRoom {
	
	@Id
	@Column(name = "blocked_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blockedId;
	@Column(name = "from_date")
	private LocalDateTime fromDate;
	@Column(name = "to_date")
	private LocalDateTime toDate;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_status_id")
	private RoomStatus roomStatus;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "is_deleted")
	private Byte isDeleted;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blocked_by_staff_id")
	private Staff blockedByStaff;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blocked_by_admin_id")
	private Admin blockedByAdmin;
	
	public Long getBlockedId() {
		return blockedId;
	}
	public void setBlockedId(Long blockedId) {
		this.blockedId = blockedId;
	}
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDateTime getToDate() {
		return toDate;
	}
	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}
	public RoomStatus getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Staff getBlockedByStaff() {
		return blockedByStaff;
	}
	public void setBlockedByStaff(Staff blockedByStaff) {
		this.blockedByStaff = blockedByStaff;
	}
	public Admin getBlockedByAdmin() {
		return blockedByAdmin;
	}
	public void setBlockedByAdmin(Admin blockedByAdmin) {
		this.blockedByAdmin = blockedByAdmin;
	}
}
