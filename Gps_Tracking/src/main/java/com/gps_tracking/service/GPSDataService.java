/**
 * @author Rajesh Pradhan
 */

package com.gps_tracking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps_tracking.model.GPSData;
import com.gps_tracking.repo.GPSDataRepository;

@Service
public class GPSDataService {
    @Autowired
    private GPSDataRepository gpsDataRepository;

    //Save GPS data to the repository
    public GPSData saveGPSData(GPSData gpsData) {
        return gpsDataRepository.save(gpsData);
    }

    
     // Retrieve GPS data for a specific vehicle within a given date range.
     
    public List<GPSData> getGPSDataByVehicleAndDateRange(Long vehicleId, LocalDate startDate, LocalDate endDate) {
        return gpsDataRepository.findByVehicleIdAndTimestampBetweenOrderByTimestamp(vehicleId, startDate, endDate);
    }

    
    //Calculate the distance traveled by a specific vehicle within a given date range.

    public double calculateDistanceTraveled(Long vehicleId, LocalDate startDate, LocalDate endDate) {
        List<GPSData> gpsDataList = getGPSDataByVehicleAndDateRange(vehicleId, startDate, endDate);

        if (gpsDataList.isEmpty() || gpsDataList.size() == 1) {
            return 0.0; // Not enough data points to calculate distance
        }

        double distance = 0.0;
        for (int i = 0; i < gpsDataList.size() - 1; i++) {
            GPSData currentPoint = gpsDataList.get(i);
            GPSData nextPoint = gpsDataList.get(i + 1);
            distance += calculateDistanceBetweenPoints(
                    currentPoint.getLatitude(), currentPoint.getLongitude(),
                    nextPoint.getLatitude(), nextPoint.getLongitude());
        }
        return distance;
    }

 
     // Calculate the distance between two GPS points using the Haversine formula.
     
    private double calculateDistanceBetweenPoints(double lat1, double lon1, double lat2, double lon2) {
        int R = 6371; // Earth's radius in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // Distance in kilometers
    }
}
