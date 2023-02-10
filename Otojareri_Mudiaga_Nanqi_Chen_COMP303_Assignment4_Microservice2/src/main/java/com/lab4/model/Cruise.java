package com.lab4.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "Cruise")
public class Cruise {
	@Id
	@Column(name="cruiseid")
	@SequenceGenerator(name="cruise_seq", sequenceName="cruise_seq") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cruise_seq")
	private int cruiseID;
	
	@Column(name="cruisedestination")
	@NotBlank(message = "Cruise Destination is mandatory")
	private String cruiseDestination;
	
	@Column(name="cruiseline")
	@NotBlank(message = "Cruise Line is mandatory")
	private String cruiseLine;
	
	@Column(name="departuredate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;
	
	@Column(name="visitingplaces")
	@NotBlank(message = "Cruise Destinations are mandatory")
	private String visitingPlaces;
	
	@Column(name="duration")
	@NotBlank(message = "Cruise Duration is mandatory")
	private String duration;
	
	@Column(name="price")
	@Digits(integer=9, fraction=2, message = "Price is mandatory, Format: NNN,NNN,NNN.NN")
	private Double Price;


	

	public Cruise() {
		
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
	public String getCruiseLine() {
		return cruiseLine;
	}
	public void setCruiseLine(String cruiseLine) {
		this.cruiseLine = cruiseLine;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getVisitingPlaces() {
		return visitingPlaces;
	}
	public void setVisitingPlaces(String visitingPlaces) {
		this.visitingPlaces = visitingPlaces;
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
