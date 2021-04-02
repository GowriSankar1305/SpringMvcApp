package com.tectoro.mvc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tectoro.mvc.enums.ImageEnum;

@Entity
@Table(name = "tbl_image")
public class Image {
	
	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	@Column(name = "image_path")
	private String imagePath;
	@Column(name = "file_extension")
	private String fileExtension;
	@Column(name = "image_size")
	private Double imageSize;
	@Column(name = "mime_type")
	private String mimeType;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	@Column(name = "original_file_name")
	private String originalFileName;
	@Column(name = "is_deleted")
	private Byte isDeleted;
	@Column(name = "image_type")
	@Enumerated(EnumType.STRING)
	private ImageEnum imageType;
	@Column(name = "hotel_id")
	private Long hotelId;
	@Column(name = "room_id")
	private Long roomId;
	@Column(name = "staff_id")
	private Long staffId;
	@Column(name = "customer_id")
	private Long customerId;
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public Double getImageSize() {
		return imageSize;
	}
	public void setImageSize(Double imageSize) {
		this.imageSize = imageSize;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
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
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public ImageEnum getImageType() {
		return imageType;
	}
	public void setImageType(ImageEnum imageType) {
		this.imageType = imageType;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
