package com.gps_tracking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps_tracking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByOwner_Id(Long ownerId);
}
