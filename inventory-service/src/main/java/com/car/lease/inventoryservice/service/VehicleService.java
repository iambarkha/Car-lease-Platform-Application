package com.car.lease.inventoryservice.service;

import com.car.lease.inventoryservice.model.dto.VehicleDTO;

import java.util.List;
/**
 * This interface keeps all service to maintain Vehicle
 * inventory
 * 
 * @author barkha
 *
 */
public interface VehicleService {
	/**
	 * This method is used to create a new vehicle records.
	 * 
	 * @param VehicleDTO VehicleRequest object to create a new Vehicle
	 * @return VehicleDTO object after successful of Vehicle record creation.
	 */
	VehicleDTO addVehicle(VehicleDTO vehicle);
	/**
	 * This method is used to update vehicle record on database
	 * 
	 * @param vehicleId      long parameter to identify vehicle object
	 * @param VehicleDTO VehicleRequest its vehicle data to update vehicle
	 *                       record
	 * @return VehicleDTO object after successful of vehicle record updates
	 */
	VehicleDTO updateVehicle(VehicleDTO vehicle, Long id);
	/**
	 * This method is used delete vehicle records.
	 * 
	 * @param id long parameter to identify vehicle object for delete object
	 */
	void deleteVehicleById(final Long id);
	/**
	 * This method is used to retrieve all Vehicle records from database
	 * 
	 * @return List<VehicleDTO> it returns list of Vehicle records from
	 *         database
	 */
	List<VehicleDTO> findAllVehicles();
	/**
	 * This method is used to find vehicle record through a valid vehicle id.
	 * 
	 * @param id long parameter to identify vehicle object
	 * @return VehicleDTO object if the id is valid
	 */
	VehicleDTO findVehicleById(final Long id);

}
