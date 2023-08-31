package com.gps_tracking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GPSData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private double latitude;
    private double longitude;
    private LocalDate timestamp;
	public GPSData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GPSData(Long id, Vehicle vehicle, double latitude, double longitude, LocalDate timestamp) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "GPSData [id=" + id + ", vehicle=" + vehicle + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", timestamp=" + timestamp + "]";
	}
    
    


}
