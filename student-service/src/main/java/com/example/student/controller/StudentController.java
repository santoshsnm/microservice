package com.example.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/welcome")
	public ResponseEntity<Object> getRoll() {

		return new ResponseEntity<>("<center><h1>Welcome Student Service</h1></center>", HttpStatus.OK);
	}

	@GetMapping("/get-student-by-id/{id}")
	public ResponseEntity<Object> getStudentByName(@PathVariable(name = "id") Long id) throws Exception {

		return new ResponseEntity<>(service.getStudentDetailsById(id), HttpStatus.OK);
	}

	@GetMapping("/get-student-by-email/{email}")
	public ResponseEntity<Object> finfByEmail(@PathVariable(value = "email") String email) {

		return new ResponseEntity<>(service.getStudentDetailsByEmail(email), HttpStatus.OK);

	}

	@PostMapping("/save-student")
	public ResponseEntity<Object> saveStudent(@RequestBody Student std) throws Exception {

		Optional<Student> student = service.getStudentDetailsByEmail(std.getEmail());
		if (student.isPresent()) {
			throw new Exception("Studuent already exist!!");
		}
		Student save = service.saveStudent(std);

		return new ResponseEntity<>(save, HttpStatus.OK);
	}

}
