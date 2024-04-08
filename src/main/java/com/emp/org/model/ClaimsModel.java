package com.emp.org.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="expense_table")
@Data
public class ClaimsModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	

	
	@Column
	private Long wbsId;
	
	
	
	@Column
	private String requestNo;
	
	@Column
	private LocalDate fromDate;
	
	@Column
	private LocalDate toDate;
	
	@Column
	private Long mobileNo;
	
	@Column
	private String purpose;
	
	@Column
	private String expenseType;
	
	@Column
	private String mode;
	
	@Column
	private String locationOfExp;
	
	@Column
	private Long amount;
	
	@Column
	private int kms;
	
	@Column
	private String fromLocation;
	
	@Column
	private String toLocation;
	
	@Column
	private String typeOfExpense;
	
	@Column
	private String status;
	
	@Column
	private String fromTime;
	
	@Column
	private String toTime;
	@Column
	private String currency;
	
	@CreationTimestamp()
	private LocalDate createdDate;
	
	@Column(name="file_name")
	private String fileName;
	
	
	 @Column(name = "file_path")
	    private String filePath;
	
	

}
