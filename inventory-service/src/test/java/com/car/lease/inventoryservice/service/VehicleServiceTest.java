package com.car.lease.inventoryservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.car.lease.inventoryservice.exception.InventorySystemException;
import com.car.lease.inventoryservice.model.Vehicle;
import com.car.lease.inventoryservice.model.dto.VehicleDTO;
import com.car.lease.inventoryservice.repository.VehicleRepository;
import com.car.lease.inventoryservice.service.impl.VehicleServiceImpl;

@DisplayName("VehicleService - Unit Test")
@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
	
	@InjectMocks
	VehicleServiceImpl inventoryService;
	
	@Mock
	VehicleRepository mockVehicleRepo;
	
	private static Vehicle vehicle = new Vehicle();
	private static VehicleDTO vehicleDto = new VehicleDTO();
	
	@BeforeAll
    public static void initiateCustomerBeforeTest(){
       
        vehicle.setId(1l);
        vehicle.setMake("KIA");
        vehicle.setModel("Sonet");
        vehicle.setNettPrice(50000);
        vehicle.setVersion("11");
        vehicle.setGrossPrice(250000);
       
        vehicleDto.setMake("KIA");
        vehicleDto.setModel("Sonet");
        vehicleDto.setNettPrice(50000);
        vehicleDto.setVersion("11");
        vehicleDto.setGrossPrice(250000);
        
		
		

    }
	@Test
    public void addVehicleShouldReturnVehicleDTO() {
        when(mockVehicleRepo.save(vehicle)).thenReturn(vehicle);
        assertEquals(inventoryService.addVehicle(vehicleDto), vehicleDto);
    }
	@Test
	public void updateVehicleShouldReturnUpdatedVehicleDTOIfIdIsValid() {
        when(mockVehicleRepo.save(vehicle)).thenReturn(vehicle);
        assertEquals(inventoryService.updateVehicle(vehicleDto,1l), vehicleDto);
    }
	@Test
	public void updateVehicleShouldReturnExceptionIfIdIsInValid() {
        when(mockVehicleRepo.findById(1l)).thenReturn(Optional.empty());
        InventorySystemException thrown = assertThrows(
        		InventorySystemException.class,
                () -> inventoryService.updateVehicle(vehicleDto,1l), "Vehicle does not exist with id ");
        assertTrue(thrown.getMessage().contains("Vehicle does not exist with id"));
    }
	@Test
	public void deleteVehicleByIdShouldDeleteCustomer() {
		verify(mockVehicleRepo).deleteById(1l);
    }
	@Test
	public void findAllVehiclesShouldReturnListOfAllVehicleDTO() {
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(vehicle);
        when(mockVehicleRepo.findAll()).thenReturn(vehicleList);
        assertEquals(inventoryService.findAllVehicles(),vehicleList);
    }
	
	@Test
	public void findVehicleByIdShouldReturnValidVehicleDTO() {
		Optional<Vehicle> optionalCustomer = Optional.of(new Vehicle());
		optionalCustomer.get().setId(1l);
		optionalCustomer.get().setMake("KIA");
        when(mockVehicleRepo.findById(1l)).thenReturn(optionalCustomer);
        assertEquals(inventoryService.findVehicleById(1l), optionalCustomer);
    }
	
	
	

	

}
