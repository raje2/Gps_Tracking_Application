/**
 * @author Rajesh Pradhan
 * 
 * Controller class for managing GPS data related operations.
 * Handles saving and retrieving GPS data for a specific vehicle, as well
 * as calculating the distance traveled by the vehicle within a date range. 
 */

package com.gps_tracking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gps_tracking.model.GPSData;
import com.gps_tracking.model.Vehicle;
import com.gps_tracking.service.GPSDataService;

@RestController
@RequestMapping("/api/vehicles/{vehicleId}/gps")
public class GPSDataController {
    @Autowired
    private GPSDataService gpsDataService;

    /**
     * Save GPS data for a specific vehicle.
     * 
     * @param vehicleId The ID of the vehicle.
     * @param gpsData   The GPS data to be saved.
     * @return A response indicating the success of saving GPS data.
     */
    @PostMapping
    public ResponseEntity<String> saveGPSData(@PathVariable Long vehicleId, @RequestBody GPSData gpsData) {
        gpsData.setVehicle(new Vehicle(vehicleId));
        gpsDataService.saveGPSData(gpsData);
        return ResponseEntity.ok("GPS data saved successfully.");
    }

    /**
     * Get GPS data for a specific vehicle within a given date range.
     * 
     * @param vehicleId The ID of the vehicle.
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return List of GPS data within the specified date range.
     */
    @GetMapping
    public ResponseEntity<List<GPSData>> getGPSDataByDateRange(
            @PathVariable Long vehicleId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        List<GPSData> gpsDataList = gpsDataService.getGPSDataByVehicleAndDateRange(vehicleId, startDate, endDate);
        return ResponseEntity.ok(gpsDataList);
    }

    /**
     * Calculate the distance traveled by a specific vehicle within a given date range.
     * 
     * @param vehicleId The ID of the vehicle.
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return The calculated distance traveled by the vehicle.
     */
    @GetMapping("/distance")
    public ResponseEntity<Double> calculateDistanceTraveled(
            @PathVariable Long vehicleId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        double distance = gpsDataService.calculateDistanceTraveled(vehicleId, startDate, endDate);
        return ResponseEntity.ok(distance);
    }
}
