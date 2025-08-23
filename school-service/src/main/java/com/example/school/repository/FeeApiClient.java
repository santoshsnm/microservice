package com.example.school.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "FEE-SERVICE")
public interface FeeApiClient {

	@CircuitBreaker(name = "FeeService", fallbackMethod = "flbGetFeeDetails")
	@GetMapping(value = "/fee/api/get-fee-details/student/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	Object getFeeDetails(@PathVariable("id") String id);

	default Object flbGetFeeDetails(String id, Throwable cause) {
		System.out.println("Exception :: " + cause.getMessage());
		return "Fee Service down!!";
	}
}
