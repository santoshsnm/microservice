package com.example.fee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fee.entity.FeePayment;

@Repository
public interface FeeRepository extends JpaRepository<FeePayment, Long> {

	@Query(nativeQuery = true,value = "select distinct * from feePayment a where a.Student_Id=:stdId")
	List<FeePayment> findByStudent(@Param("stdId")Integer stdid);
}
