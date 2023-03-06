package com.car.lease.brokerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BrokerServiceClient {

	@Autowired
	private RestTemplate restTemplate;
	/**
	 * this method is used to get response from other service through authentication token
	 * @param <R>           generic type for request parameters
	 * @param url           Base URL for service to service communication
	 * @param responseClass response type class
	 * @param token         jwt token
	 * @return generic response
	 */
	public <R> ResponseEntity<R> getRequestExchange(String url, Class<R> responseClass, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",token);
		HttpEntity request = new HttpEntity(headers);

		return restTemplate.exchange(url, HttpMethod.GET, request, responseClass);

	}
	 

}
