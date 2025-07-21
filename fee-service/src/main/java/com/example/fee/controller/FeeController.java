package com.example.fee.controller;

import java.util.List;
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

import com.example.fee.entity.FeePayment;
import com.example.fee.service.FeePaymentService;

@RestController
@RequestMapping("/api")
public class FeeController {

	@Autowired
	FeePaymentService serv;

	@GetMapping("/get-fee-details")
	public ResponseEntity<Object> findAllFeePaid() {
		return new ResponseEntity<>(serv.getAllFeeDetails(), HttpStatus.OK);

	}

	@GetMapping("/get-fee-details/student/{stdId}")
	public ResponseEntity<Object> findByStudentPaid(@PathVariable(value = "stdId") Integer stdId) throws Exception {

		return new ResponseEntity<Object>(serv.getPaymentByStudent(stdId), HttpStatus.OK);
	}

	@PostMapping("save-fee-student")
	public ResponseEntity<Object> saveStudentPaid(@RequestBody FeePayment feePaid) {

		FeePayment saveFee = serv.saveFee(feePaid);
		return new ResponseEntity<Object>(saveFee, HttpStatus.OK);

	}

}
