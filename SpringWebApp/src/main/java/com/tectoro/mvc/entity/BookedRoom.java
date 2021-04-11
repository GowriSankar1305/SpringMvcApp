package com.tectoro.mvc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tectoro.mvc.enums.BookingFlag;

@Entity
@Table(name = "tbl_booked_room")
public class BookedRoom {
	
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	@Column(name = "booking_code")
	private String bookingCode;
	@Column(name = "booking_from_date")
	private LocalDateTime bookedFrom;
	@Column(name = "booking_to_date")
	private LocalDateTime bookedTo;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "check_in_time")
	private LocalDateTime checkInTime;
	@Column(name = "check_out_time")
	private LocalDateTime checkOutTime;
	@Column(name = "no_of_persons")
	private Short noOfPersons;
	@Column(name = "no_of_men")
	private Short men;
	@Column(name = "no_of_women")
	private Short women;
	@Column(name = "no_of_kids")
	private Short kids;
	@Column(name = "no_of_extra_persons")
	private Short extraPersons;
	@Enumerated(EnumType.STRING)
	@Column(name = "booking_flag")
	private BookingFlag bookingFlag;
	@Column(name = "booked_date")
	private LocalDateTime bookedDate;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booked_by_staff_id")
	private Staff bookedByStaff;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booked_by_admin_id")
	private Admin bookedByAdmin;
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDateTime getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(LocalDateTime bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public LocalDateTime getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(LocalDateTime bookedTo) {
		this.bookedTo = bookedTo;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}
	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public Short getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(Short noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public Short getMen() {
		return men;
	}
	public void setMen(Short men) {
		this.men = men;
	}
	public Short getWomen() {
		return women;
	}
	public void setWomen(Short women) {
		this.women = women;
	}
	public Short getKids() {
		return kids;
	}
	public void setKids(Short kids) {
		this.kids = kids;
	}
	public BookingFlag getBookingFlag() {
		return bookingFlag;
	}
	public void setBookingFlag(BookingFlag bookingFlag) {
		this.bookingFlag = bookingFlag;
	}
	public LocalDateTime getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(LocalDateTime bookedDate) {
		this.bookedDate = bookedDate;
	}
	public Staff getBookedByStaff() {
		return bookedByStaff;
	}
	public void setBookedByStaff(Staff bookedByStaff) {
		this.bookedByStaff = bookedByStaff;
	}
	public Admin getBookedByAdmin() {
		return bookedByAdmin;
	}
	public void setBookedByAdmin(Admin bookedByAdmin) {
		this.bookedByAdmin = bookedByAdmin;
	}
}
