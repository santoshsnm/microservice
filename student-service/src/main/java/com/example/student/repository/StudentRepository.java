package com.example.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(nativeQuery = true, value = "select a.* from student a where a.email=:email")
	Optional<Student> findByEmail(@Param("email") String email);
}
