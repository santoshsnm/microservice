package com.example.school.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "STUDENT-SERVICE")
public interface StudentApiClient {

	@CircuitBreaker(name = "StudentService", fallbackMethod = "flbGetStudentDetails")
	@GetMapping(value = "/student/api/get-student-by-id/{id}")
	Object getStudentDetails(@PathVariable("id") String id);

	default Object flbGetStudentDetails(String id, Throwable cause) {
		return "student Service down!!";

	}
}
