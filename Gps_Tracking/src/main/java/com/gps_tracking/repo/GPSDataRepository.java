package com.gps_tracking.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps_tracking.model.GPSData;

public interface GPSDataRepository extends JpaRepository<GPSData, Long>{
	List<GPSData> findByVehicleIdAndTimestampBetweenOrderByTimestamp(Long vehicleId, LocalDate startDate, LocalDate endDate);
}
