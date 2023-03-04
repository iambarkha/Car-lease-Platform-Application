package com.car.lease.authservice.service.impl;

import java.sql.Timestamp;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.car.lease.authservice.mapper.CustomDTOMapperInterface;
import com.car.lease.authservice.model.AuthenticationStatus;
import com.car.lease.authservice.model.LoginRequest;
import com.car.lease.authservice.model.User;
import com.car.lease.authservice.model.dto.UserRequest;
import com.car.lease.authservice.model.dto.UserResponse;
import com.car.lease.authservice.repository.UserRepository;
import com.car.lease.authservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	CustomDTOMapperInterface mapper = Mappers.getMapper(CustomDTOMapperInterface.class);
	
	/*
	 * @Autowired public PasswordEncoder passwordEncoder;
	 */
	
	@Override
	public UserResponse createUser(final UserRequest userRequest) {
		log.trace("User create request in service for :: {}", userRequest);
		User user = mapper.userRequestToUser(userRequest);
		user.setPassword(userRequest.getPassword());
		user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		User response = userRepository.save(user);
		log.trace("User creation request sucessfull");
		return mapper.userToUserResponse(response);
	}

	@Override
	public User findByUserName(String userName) {
		log.trace("Find by username request for :: {}", userName);
		User user = userRepository.findByUserName(userName);
		return user;
	}

	@Override
	public AuthenticationStatus getAuthenticationStatus(LoginRequest request) {
		log.trace("Get AuthenticationStatus for login request", request);
		AuthenticationStatus status;
		User user = findByUserName(request.getUserName());
		if (!request.getUserName().equals(user.getUserName())
				&& !request.getPassword().equals(user.getPassword())) {
			status = new AuthenticationStatus(false, "Invalid Username/Password");
			log.trace("Invalid userName and password");
		}
		else {
			status = new AuthenticationStatus(true, "Authentication Successful");
			log.trace("Authentication Successful");
		}

		return status;
	}

}
