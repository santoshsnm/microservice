package com.example.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService serv;

	@GetMapping("/welcome")
	public ResponseEntity<Object> welcome() {

		return new ResponseEntity<>("<h1>Hi Employe service Welcome</h1>", HttpStatus.OK);

	}

	@GetMapping("/employee-list")
	public ResponseEntity<Object> getEmployee() {
		List<String> employee = serv.getEmployee();
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}
