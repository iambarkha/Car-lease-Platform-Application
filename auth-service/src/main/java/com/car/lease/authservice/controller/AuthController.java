package com.car.lease.authservice.controller;

import com.car.lease.authservice.model.AuthenticationStatus;
import com.car.lease.authservice.model.LoginRequest;
import com.car.lease.authservice.model.dto.UserRequest;
import com.car.lease.authservice.model.dto.UserResponse;
import com.car.lease.authservice.service.UserService;
import com.car.lease.authservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * This class represents for all authorization apis
 * 
 * @author barkha
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/auth")
@Slf4j
public class AuthController {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserService userService;


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		log.trace("User Login request", loginRequest);
		AuthenticationStatus status = userService.getAuthenticationStatus(loginRequest);
		log.trace("User authentication status", status);
		if (!status.getIsAuthenticated()) {
			String detail = status.getMessage();
			log.trace("User is not authorized");
			return new ResponseEntity<>(detail, HttpStatus.UNAUTHORIZED);
		}
		final String token = jwtUtil.generateToken(loginRequest.getUserName());
		log.info("Token authentication completed sucessfully");
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
		// Persist user to User table
		log.trace("New user registration request :: {}", userRequest);
		UserResponse user = userService.createUser(userRequest);
		log.trace("New user registration request sucessfull");
		return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
	}

}
