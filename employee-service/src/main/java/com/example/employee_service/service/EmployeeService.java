package com.example.employee_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public List<String> getEmployee() {
		List<String> list = Arrays.asList("Santosh", "Vamshi", "Dev");
		return list;
	}

}
