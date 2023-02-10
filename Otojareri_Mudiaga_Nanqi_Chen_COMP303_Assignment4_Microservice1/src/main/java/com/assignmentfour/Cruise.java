package com.assignmentfour;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Cruise")
public class Cruise {
	@Id
	@Column(name="cruiseid")
	@NotBlank(message = "Cruise is mandatory")
	private int cruiseID;
	
	@Column(name="cruisedestination")
	@NotBlank(message = "cruise destination is mandatory")
	private String cruiseDestination;
	
	@Column(name="departuredate")
	@NotBlank(message = "departure date is mandatory")
	private Date departureDate;
	
	@Column(name="duration")
	@NotBlank(message = "Duration is mandatory")
	private String duration;
	
	@Column(name="price")
	@NotBlank(message = "Price is mandatory")
	private Double Price;
	
	public Cruise() {
		super();
	}
	
	public Cruise(@NotBlank(message = "Cruise is mandatory") int cruiseID,
			@NotBlank(message = "cruise destination is mandatory") String cruiseDestination,
			@NotBlank(message = "departure date is mandatory") Date departureDate,
			@NotBlank(message = "Duration is mandatory") String duration,
			@NotBlank(message = "Price is mandatory") Double price) {
		super();
		this.cruiseID = cruiseID;
		this.cruiseDestination = cruiseDestination;
		this.departureDate = departureDate;
		this.duration = duration;
		Price = price;
	}

	public int getCruiseID() {
		return cruiseID;
	}
	public void setCruiseID(int cruiseID) {
		this.cruiseID = cruiseID;
	}
	public String getCruiseDestination() {
		return cruiseDestination;
	}
	public void setCruiseDestination(String cruiseDestination) {
		this.cruiseDestination = cruiseDestination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}


}
