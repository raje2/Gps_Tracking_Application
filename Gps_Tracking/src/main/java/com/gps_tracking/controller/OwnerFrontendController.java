/**
 * @author Rajesh Pradhan
 * 
 * Controller class for handling frontend interactions related to owners.
 * Manages owner forms, vehicle lists, and distance calculations.
 */
package com.gps_tracking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gps_tracking.holder.OwnerIdHolder;
import com.gps_tracking.model.Vehicle;
import com.gps_tracking.service.GPSDataService;
import com.gps_tracking.service.VehicleService;

@Controller
public class OwnerFrontendController {
	
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private GPSDataService gpsDataService;

    /**
     * Show the owner form.
     * 
     * @return The name of the owner form JSP.
     */
    @GetMapping("/owner-form")
    public String showOwnerForm() {
        return "ownerForm";
    }
    
    /**
     * Redirect to the vehicle list page for a specific owner.
     * 
     * @param ownerId The ID of the owner.
     * @param model   The Spring MVC model.
     * @return The name of the vehicle list JSP.
     */
    @GetMapping("/get-vehicles")
    public String redirectToVehicleList(@RequestParam Long ownerId, Model model) {
    	
    	//here we hold the owner id for use in authentication
        OwnerIdHolder.setId(ownerId);
    	
        List<Vehicle> vehicles = vehicleService.getVehiclesByOwnerId(ownerId);
        model.addAttribute("vehicles", vehicles);
        return "vehicleList";
    }
    
    /**
     * Calculate and display the distance traveled by a vehicle within a date range.
     * 
     * @param vehicleId The ID of the vehicle.
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @param model     The Spring MVC model.
     * @return The name of the distance result JSP.
     */
    @GetMapping("/get-distance")
    public String getDistance(
            @RequestParam Long vehicleId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            Model model) {

    	//here we take the owner id for matching with the vehicle
        Long ownerIdInCache = OwnerIdHolder.getId();
        		
        if (vehicleService.getVehicleById(vehicleId).isPresent()) {
            Vehicle vehicle = vehicleService.getVehicleById(vehicleId).get();
            
            if (vehicle.getOwner().getId().equals(ownerIdInCache)) {
                double distance = gpsDataService.calculateDistanceTraveled(vehicleId, startDate, endDate);
                model.addAttribute("vehicle", vehicle);
                model.addAttribute("distance", distance);
                return "distanceResult";
            } else {
                String errorMessage = "You don't have this vehicle.";
                model.addAttribute("errorMessage", errorMessage);
                return "distanceResult"; 
            }
        } else {
            String errorMessage = "Vehicle not found.";
            model.addAttribute("errorMessage", errorMessage);
            return "distanceResult"; 
        }
    }
}
