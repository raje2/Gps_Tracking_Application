package com.gps_tracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps_tracking.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{
    
}
