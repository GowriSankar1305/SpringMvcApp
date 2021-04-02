package com.tectoro.mvc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_room_status")
public class RoomStatus {
	
	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;
	@Column(name = "status")
	private String status;
	@Column(name = "status_icon")
	private String statusIcon;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusIcon() {
		return statusIcon;
	}
	public void setStatusIcon(String statusIcon) {
		this.statusIcon = statusIcon;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
