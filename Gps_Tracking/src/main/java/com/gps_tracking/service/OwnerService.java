/**
 * @author Rajesh Pradhan
 */

package com.gps_tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps_tracking.model.Owner;
import com.gps_tracking.repo.OwnerRepository;

@Service
public class OwnerService {
	
	@Autowired
    private OwnerRepository ownerRepository;
	
	//creating owner
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }
    
    //get all owner list
    public List<Owner> getOwnerList() {
        return ownerRepository.findAll();
    }
    
    //delete by using owner id
    public void deleteByID(Long id) {
    	 ownerRepository.deleteById(id);
    }

    //get owner by id
    public Optional<Owner> getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }
    
}
