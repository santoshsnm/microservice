package com.example.fee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fee.entity.FeePayment;
import com.example.fee.repository.FeeRepository;

@Service
public class FeePaymentService {

	@Autowired
	FeeRepository repo;

	public FeePayment saveFee(FeePayment feePay) {

		return repo.save(feePay);
	}

	public List<FeePayment> getPaymentByStudent(Integer stdId) {

		return repo.findByStudent(stdId);
	}

	public List<FeePayment> getAllFeeDetails() {
		return repo.findAll();
	}

}
