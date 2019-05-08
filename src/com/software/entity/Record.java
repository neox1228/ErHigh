package com.software.entity;

import java.sql.Date;

public class Record {
	private long id;
	private long userId;
	private long carId;
	private Date startDate;
	private Date ReturnDate;
	private double payment;
	
	public Record() {
		super();
	}
	public Record(long id, long userId, long carId, Date startDate, Date returnDate, double payment) {
		super();
		this.id = id;
		this.userId = userId;
		this.carId = carId;
		this.startDate = startDate;
		ReturnDate = returnDate;
		this.payment = payment;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", userId=" + userId + ", carId=" + carId + ", startDate=" + startDate
				+ ", ReturnDate=" + ReturnDate + ", payment=" + payment + "]";
	}
	
}
