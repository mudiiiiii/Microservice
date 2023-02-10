package com.assignmentfour;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@SequenceGenerator(name="book_seq", sequenceName="booking_seq") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="book_seq")
	@Column (name="bookingid")
	private int bookingID;
	
	@Column (name = "custid")
	@Min(value = 0, message = "Customer id is mandatory")
	private int custID;
	
	@Column (name = "cruiseid")
	@Min(value = 0, message = "Cruise id is mandatory")
	private int cruiseID;
	
	@Column (name = "numberofguests")
	@Min(value = 0, message = "Number of guest is mandatory")
	private int numberOfGuests;
	
	@Column (name = "totalAmount")
	@Min(value = 0, message = "Total Amount is mandatory")
	private double totalAmount;
	
	@Column (name = "status")
	@NotBlank(message = "Status is mandatory")
	private String status;
	
	public Booking() {
		super();
	}
	

	public Booking(@Min(value = 0, message = "Customer id is mandatory") int custID,
			@Min(value = 0, message = "Cruise id is mandatory") int cruiseID,
			@Min(value = 0, message = "Number of guest is mandatory") int numberOfGuests,
			@Min(value = 0, message = "Total Amount is mandatory") double totalAmount,
			@NotBlank(message = "Status is mandatory") String status) {
		super();
		this.custID = custID;
		this.cruiseID = cruiseID;
		this.numberOfGuests = numberOfGuests;
		this.totalAmount = totalAmount;
		this.status = status;
	}


	public Booking(int bookingID, @Min(value = 0, message = "Customer id is mandatory") int custID,
			@Min(value = 0, message = "Cruise id is mandatory") int cruiseID,
			@Min(value = 0, message = "Number of guest is mandatory") int numberOfGuests,
			@Min(value = 0, message = "Total Amount is mandatory") double totalAmount,
			@NotBlank(message = "Status is mandatory") String status) {
		super();
		this.bookingID = bookingID;
		this.custID = custID;
		this.cruiseID = cruiseID;
		this.numberOfGuests = numberOfGuests;
		this.totalAmount = totalAmount;
		this.status = status;
	}


	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public int getCruiseID() {
		return cruiseID;
	}
	public void setCruiseID(int cruiseID) {
		this.cruiseID = cruiseID;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}


	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double TotalAmount (int numberOfGuests, double Price) {
		double ta = numberOfGuests * Price;
		return ta;
	}

}
