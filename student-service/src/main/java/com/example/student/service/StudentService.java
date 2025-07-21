package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;

	public List<Student> getStudentDetails() {

		return repo.findAll();
	}

	public Optional<Student> getStudentDetailsById(Long id) {
		return repo.findById(id);
	}

	public Optional<Student> getStudentDetailsByEmail(String email) {

		return repo.findByEmail(email);
	}

	public Student saveStudent(Student std) {

		return repo.save(std);
	}

}
