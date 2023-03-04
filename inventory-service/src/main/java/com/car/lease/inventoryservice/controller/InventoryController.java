package com.car.lease.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.lease.inventoryservice.model.dto.VehicleDTO;
import com.car.lease.inventoryservice.service.VehicleService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
/**
 * This class has all Apis to manage Vehicle operation like Add,update,delete,find customer operations
 * 
 * @author barkha
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/inventory")
@Tag(name = "Inventory controller API to  manage Vehicle")
@SecurityRequirement(name = "bearerAuth")
@Slf4j
public class InventoryController {
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/findAllVehicles")
	public ResponseEntity<List<VehicleDTO>> getAllVehicle() {
		log.trace("Inside getAllVehicle");
		List<VehicleDTO> vehicles = vehicleService.findAllVehicles();
		log.info("Inside getAllVehicle", vehicles);
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vh) {
		log.trace("Inside add Vehicle with request ", vh);
		return new ResponseEntity<VehicleDTO>(vehicleService.addVehicle(vh), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateVehicle/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vh,@PathVariable Long id ) {
		log.trace("Inside update Vehicle for customer id", id);
		VehicleDTO vehicle = vehicleService.updateVehicle(vh, id);
		log.trace("After update vehicle", id);
        return new ResponseEntity<VehicleDTO>(vehicle, HttpStatus.CREATED);
    }
	
	@GetMapping("/findVehicleById/{id}")
	public ResponseEntity<VehicleDTO> findVehicleById(@PathVariable Long id) {
		log.trace("Inside findVehicleById vehicle id", id);
		VehicleDTO vehicle = vehicleService.findVehicleById(id);
		System.out.println("vehicles ====== " + vehicle);
		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteVehicleById(@PathVariable("id") Long id) {
		log.trace("Inside deleteVehicleById ",id);
		vehicleService.deleteVehicleById(id);
		log.trace("Vehicle deleted successfully");
		return new ResponseEntity(HttpStatus.OK);
	}

}
