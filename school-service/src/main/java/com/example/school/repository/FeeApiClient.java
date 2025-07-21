package com.example.school.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "FEE-SERVICE", url = "http://localhost:8083")
public interface FeeApiClient {
	
	@GetMapping(value = "/fee/api/get-fee-details/student/{id}")
    Object getFeeDetails(@PathVariable("id") String id);
}
