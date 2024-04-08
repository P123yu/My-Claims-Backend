package com.emp.org.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp_table")
@Data
public class EmpInfoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	
	
	@Column
	private String empName;
	
	@Column
	private String email;
	
		
	@Column
	private Long empCode;
	
	@Column
	private String manager;
	
	
	@Column
	private Long mobile;
	
	@Column
	private Long wbs;
	
	@Column
	private String typeOfExpense;
	
	@Column
	private String description;
	
	

}
