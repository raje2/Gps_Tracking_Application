/**
 ** @author Rajesh Pradhan
 *
 * Controller class for managing vehicle-related operations.
 * Handles creation of vehicles associated with an owner.
 */
package com.gps_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps_tracking.model.Vehicle;
import com.gps_tracking.service.VehicleService;

@RestController
@RequestMapping("/api/owners/{ownerId}/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    /**
     * Create a new vehicle associated with the specified owner.
     * 
     * @param ownerId The ID of the owner.
     * @param vehicle The vehicle information.
     * @return The created vehicle.
     */
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@PathVariable Long ownerId, @RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.createVehicle(ownerId, vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }
}
