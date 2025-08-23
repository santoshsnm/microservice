package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service(value = "StudentService")
@Scope(value = "singleton")
public class StudentService {

	@Autowired
	StudentRepository repo;

	public List<Student> getStudentDetails() {

		return repo.findAll();
	}

	@CircuitBreaker(name = "StudentService", fallbackMethod = "flbStudentDetailsById")
	public Optional<Student> getStudentDetailsById(Long id) throws Exception {
		try {
			return repo.findById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}

	}
	//Fallback get-student-by-id
	public Optional<Student> flbStudentDetailsById(Long id, Exception ex) {
		return null;
	}

	public Optional<Student> getStudentDetailsByEmail(String email) {

		return repo.findByEmail(email);
	}

	public Student saveStudent(Student std) {

		return repo.save(std);
	}

}
