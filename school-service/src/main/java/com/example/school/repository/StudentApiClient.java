package com.example.school.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "STUDENT-SERVICE", url = "http://localhost:8082")
public interface StudentApiClient {
	
	@GetMapping(value = "/student/api/get-student-by-id/{id}")
    Object getStudentDetails(@PathVariable("id") String id);

}
