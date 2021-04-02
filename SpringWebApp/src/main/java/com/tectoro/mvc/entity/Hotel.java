package com.tectoro.mvc.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tectoro.mvc.enums.PaymentType;

@Entity
@Table(name = "tbl_hotel")
public class Hotel {
	
	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;
	@Column(name = "hotel_name")
	private String hotelName;
	@Column(name = "hotel_address")
	private String hotelAddress;
	@Column(name = "hotel_code")
	private String hotelCode;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(
			name = "hotel_room_type",
			joinColumns = @JoinColumn(name="hotel_id"),
			inverseJoinColumns = @JoinColumn(name="room_type_id")
	)
	private List<RoomType> roomTypes;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<Room> rooms;
	@Column(name = "primary_contact_number")
	private String primaryContactNumber;
	@Column(name = "secondary_contact_number")
	private String secondaryContactNumber;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<PaymentType> paymentypes;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(
			name = "hotel_facility",
			joinColumns = @JoinColumn(name="hotel_id"),
			inverseJoinColumns = @JoinColumn(name="facility_id")
	)
	private List<Facility> hotelFacilities;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	private Admin admin;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	@Column(name = "is_active")
	private Byte isActive;
	@Column(name = "no_of_floors")
	private Integer noOfFloors;
	
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	public List<RoomType> getRoomTypes() {
		return roomTypes;
	}
	public void setRoomTypes(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}
	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}
	public String getSecondaryContactNumber() {
		return secondaryContactNumber;
	}
	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
	}
	public List<PaymentType> getPaymentypes() {
		return paymentypes;
	}
	public void setPaymentypes(List<PaymentType> paymentypes) {
		this.paymentypes = paymentypes;
	}
	public List<Facility> getHotelFacilities() {
		return hotelFacilities;
	}
	public void setHotelFacilities(List<Facility> hotelFacilities) {
		this.hotelFacilities = hotelFacilities;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
	public Byte getIsActive() {
		return isActive;
	}
	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}
}
