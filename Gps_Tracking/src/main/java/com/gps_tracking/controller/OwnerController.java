/**
 * @author Rajesh Pradhan
 * Controller for managing owner-related operations
 */

package com.gps_tracking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps_tracking.model.Owner;
import com.gps_tracking.service.OwnerService;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    // Create a new owner
    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner createdOwner = ownerService.createOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOwner);
    }

    // Get a list of owners
    @PostMapping("/getList")
    public ResponseEntity<List<Owner>> getList() {
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.getOwnerList());
    }

    // Delete an owner by ID
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<String> deleteById(@PathVariable Long ownerId) {
        ownerService.deleteByID(ownerId);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
    }

    // Get an owner by ID
    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long ownerId) {
        Optional<Owner> owner = ownerService.getOwnerById(ownerId);
        return owner.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
