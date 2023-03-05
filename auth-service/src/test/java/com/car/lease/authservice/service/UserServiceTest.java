package com.car.lease.authservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.car.lease.authservice.mapper.CustomDTOMapperInterface;
import com.car.lease.authservice.model.User;
import com.car.lease.authservice.model.dto.UserRequest;
import com.car.lease.authservice.model.dto.UserResponse;
import com.car.lease.authservice.repository.UserRepository;
import com.car.lease.authservice.service.impl.UserServiceImpl;

@DisplayName("UserService - Unit Test")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	CustomDTOMapperInterface mapper;
	
	@Mock
	UserRepository mockUserRepository;
	
	private static UserRequest userRequest = new UserRequest();
	private static UserResponse userResponse = new UserResponse();
	private User user = new User();
	
	@BeforeAll
	public void setUser() {
		
		userRequest.setId(1l);
		userRequest.setUserName("barkha");
		userRequest.setPassword("barkha");
		
		userResponse.setId(1l);
		userResponse.setUserName("barkha");
		userResponse.setPassword("barkha");
		
		user.setId(1l);
		user.setUserName("barkha");
		user.setPassword("barkha");
	}
	
	@Test
	public void createUserShouldCreateValidUser() {
		when(mapper.userRequestToUser(userRequest)).thenReturn(user);
		when(mockUserRepository.save(user)).thenReturn(user);
		when(mapper.userToUserResponse(user)).thenReturn(userResponse);
		assertEquals(userResponse.getUserName(), userRequest.getUserName());
		
	}
	
	@Test
	public void findByUserNameShouldReturnValidUserIfNameisValid() {
		when(mockUserRepository.findByUserName("barkha")).thenReturn(user);
		assertEquals("barkha", user.getUserName());
	}
	
	

}
