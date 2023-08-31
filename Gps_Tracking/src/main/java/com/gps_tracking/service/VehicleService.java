/**
 * @author Rajesh Pradhan
 */

package com.gps_tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps_tracking.model.Owner;
import com.gps_tracking.model.Vehicle;
import com.gps_tracking.repo.VehicleRepository;

@Service
public class VehicleService {
	 @Autowired
	 private VehicleRepository vehicleRepository;
	 
	 @Autowired
	 private OwnerService ownerService;

	 //creating vehicle
	    public Vehicle createVehicle(Long ownerId, Vehicle vehicle) {
	        Owner owner = ownerService.getOwnerById(ownerId)
	                .orElseThrow(() -> new RuntimeException("Owner not found"));

	        vehicle.setOwner(owner);
	        return vehicleRepository.save(vehicle);
	    }
	    
	    
	    //get vehicle by using id
	    public Optional<Vehicle> getVehicleById(Long vehicleId) {
	        return vehicleRepository.findById(vehicleId);
	    }
	    
	    //get vehicle list of owner by using owner id
	    public List<Vehicle> getVehiclesByOwnerId(Long ownerId) {
	        return vehicleRepository.findByOwner_Id(ownerId);
	    }
}
