package com.lab4.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@SequenceGenerator(name="employee_seq", sequenceName="employee_seq") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_seq")
	private int empId;
	
	@Column(nullable = false, unique = true, length = 45)
	private String userName;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(name = "emp_name", nullable = false, length = 20)
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	

}
