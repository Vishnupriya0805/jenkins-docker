package com.ltts.sparkle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employeetable")
public class Employee {
	@Id
	private int Empid;
	private String EmpName;
	private String EmailAddress;
	private String Gender;
	private String Salary;
	private String Mobile;
	
	
	public Employee(int empid, String empName, String emailAddress, String gender, String salary, String mobile) {
		super();
		Empid = empid;
		EmpName = empName;
		EmailAddress = emailAddress;
		Gender = gender;
		Salary = salary;
		Mobile = mobile;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmpid() {
		return Empid;
	}


	public void setEmpid(int empid) {
		Empid = empid;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public String getEmailAddress() {
		return EmailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getSalary() {
		return Salary;
	}


	public void setSalary(String salary) {
		Salary = salary;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	@Override
	public String toString() {
		return "Employee [Empid=" + Empid + ", EmpName=" + EmpName + ", EmailAddress=" + EmailAddress + ", Gender="
				+ Gender + ", Salary=" + Salary + ", Mobile=" + Mobile + "]";
	}
	
	
	
	
	
}
/*
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int Empid;
	
	@Column(name = "empname")
	private String EmpName;
	
	@Column(name = "emailaddress")
	private String EmailAddress;
	
	@NotNull()
	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "salary")
	private String Salary;
	
	@Column(name = "mobile")
	private String Mobile;

}
*/
	
	