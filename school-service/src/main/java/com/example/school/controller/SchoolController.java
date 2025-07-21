package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	SchoolService serv;

	@GetMapping("/get-student-details/student/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable(value = "id") String id) {

		Object stdDetails = serv.getStudentDetailsById(id);

		return new ResponseEntity<>(stdDetails, HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public ResponseEntity<Object> getDetails() {

		return new ResponseEntity<>("Hii welome", HttpStatus.OK);
	}

}
