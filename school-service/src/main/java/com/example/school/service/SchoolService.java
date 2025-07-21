package com.example.school.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.school.repository.FeeApiClient;
import com.example.school.repository.StudentApiClient;

@Service
@Configuration
public class SchoolService {

	@Autowired
	StudentApiClient stdClient;

	@Autowired
	FeeApiClient feeClient;

	public Object getStudentDetailsById(String id) {

		Map<String, Object> map = new LinkedHashMap<>();
		
		//calling student service
		Object student = stdClient.getStudentDetails(id);
		//calling fee service
		Object payment = feeClient.getFeeDetails(id);

		map.put("student", student);
		map.put("fee", payment);

		return map;

	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
