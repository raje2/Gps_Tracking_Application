package com.gps_tracking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationNumber;
    private String bikeModel;
    private LocalDate insuranceExpiryDate;
    private LocalDate purchasedDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vehicle(Long id) {
		super();
		this.id = id;
	}



	public Vehicle(Long id, String registrationNumber, String bikeModel, LocalDate insuranceExpiryDate,
			LocalDate purchasedDate, Owner owner) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.bikeModel = bikeModel;
		this.insuranceExpiryDate = insuranceExpiryDate;
		this.purchasedDate = purchasedDate;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public LocalDate getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}

	public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}

	public LocalDate getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDate purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", registrationNumber=" + registrationNumber + ", bikeModel=" + bikeModel
				+ ", insuranceExpiryDate=" + insuranceExpiryDate + ", purchasedDate=" + purchasedDate + ", owner="
				+ owner + "]";
	}
    
    

}
