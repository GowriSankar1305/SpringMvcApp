package com.tectoro.mvc.entity;

import java.math.BigDecimal;
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

import com.tectoro.mvc.enums.PaymentType;

@Entity
@Table(name = "tbl_payment_details")
public class PaymentDetails {
	
	@Id
	@Column(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	@Column(name = "transaction_number")
	private String transactionumber;
	@Column(name = "payment_date")
	private LocalDateTime paymentDate;
	@Column(name = "paid_amount")
	private BigDecimal paidAmount;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_type_id")
	private PaymentType paymentType;
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "expiry_date")
	private String expiryDate;
	@Column(name = "cgst")
	private BigDecimal cgst;
	@Column(name = "sgst")
	private BigDecimal sgst;
	@Column(name = "other_charges")
	private BigDecimal otherCharges;
	@Column(name = "room_charges")
	private BigDecimal roomCharges;
	@Column(name = "discount_amount")
	private BigDecimal discount;
	@Column(name = "food_charges")
	private BigDecimal foodCharges;
	@Column(name = "grand_total")
	private BigDecimal grandTotal;
	@Column(name = "sub_total")
	private BigDecimal subTotal;
	@Column(name = "room_id")
	private Long roomId;
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getTransactionumber() {
		return transactionumber;
	}
	public void setTransactionumber(String transactionumber) {
		this.transactionumber = transactionumber;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public BigDecimal getCgst() {
		return cgst;
	}
	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}
	public BigDecimal getSgst() {
		return sgst;
	}
	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}
	public BigDecimal getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(BigDecimal otherCharges) {
		this.otherCharges = otherCharges;
	}
	public BigDecimal getRoomCharges() {
		return roomCharges;
	}
	public void setRoomCharges(BigDecimal roomCharges) {
		this.roomCharges = roomCharges;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getFoodCharges() {
		return foodCharges;
	}
	public void setFoodCharges(BigDecimal foodCharges) {
		this.foodCharges = foodCharges;
	}
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
}
