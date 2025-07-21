package com.example.fee.entity;

import java.sql.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FEEPAYMENT")
public class FeePayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;

	@Nonnull
	@Column(name = "studentId")
	private Long studentId;

	@Nonnull
	@Column(name = "month")
	private String month;

	@Nonnull
	@Column(name = "paidAmt")
	private Integer paidAmt;

	@Nonnull
	@Column(name = "paidDate")
	private Date paidDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(Integer paidAmt) {
		this.paidAmt = paidAmt;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public FeePayment(Long id, Long studentId, String month, Integer paidAmt, Date paidDate) {
		super();
		Id = id;
		this.studentId = studentId;
		this.month = month;
		this.paidAmt = paidAmt;
		this.paidDate = paidDate;
	}

	public FeePayment() {
		super();

	}
}
