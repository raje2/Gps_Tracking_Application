package com.gps_tracking.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private String address;
    private String phoneNumber;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles = new ArrayList<>();

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Long id, String name, String licenseNumber, String address, String phoneNumber, String email,
			List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vehicles = vehicles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", licenseNumber=" + licenseNumber + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", vehicles=" + vehicles + "]";
	}
    
    

}
