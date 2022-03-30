package com.ltts.sparkle.controller;


import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.sparkle.service.EmployeeService;
import com.ltts.sparkle.bo.EmployeeBo;
import com.ltts.sparkle.model.Employee;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@Autowired
	EmployeeBo employeebo;
	
		
	@GetMapping("/Employeee")
	public List<Employee> m1(){
		return employeeservice.Employeelist() ;
	}
	
	@PostMapping("/Employeee")
	public ResponseEntity<String> m2(@Valid @RequestBody Employee employee){
		String errmsg="";
		boolean ferr=false;
		if(employee.getEmpName().isBlank()) {
			errmsg+="Name Should Not Be Empty\n";
			ferr=true;
		}
		if(!Pattern.matches("[a-zA-Z]+",employee.getEmpName())) {
			errmsg+="Employee name should contain only alphabets\n";
			ferr=true;
		}if(!Pattern.matches("[0-9]{10}+",employee.getMobile())) {
			errmsg+="Mobile Number specified is not valid\n";
			ferr=true;
		}if(!Pattern.matches("[1-9][0-9]{2,}",employee.getSalary())) {
			errmsg+="Salary specified is not valid\n";
			ferr = true;
		}if(!Pattern.matches("[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",employee.getEmailAddress())) {
			errmsg+="Please Enter a Valid Email Address\n";
			ferr = true;
		}
		if(ferr) {
			return new ResponseEntity(errmsg,HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			employeeservice.insertEmployee(employee);
			return  ResponseEntity.ok("User Data Has Been Entred Successfully");
		}	
		
	}
	
	@PutMapping("/Employeee/{id}")
	public ResponseEntity<String> update(@RequestBody Employee employee,@PathVariable int id) {
		String errmsg="";
		boolean ferr=false;
		if(employee.getEmpName().isBlank()) {
			errmsg+="Name Should Not Be Empty\n";
			ferr=true;
		}
		if(!Pattern.matches("[a-zA-Z]+",employee.getEmpName())) {
			errmsg+="Employee name should contain only alphabets\n";
			ferr=true;
		}if(!Pattern.matches("[0-9]{10}+",employee.getMobile())) {
			errmsg+="Mobile Number specified is not valid\n";
			ferr=true;
		}if(!Pattern.matches("[1-9][0-9]{2,}",employee.getSalary())) {
			errmsg+="Salary specified is not valid\n";
			ferr = true;
		}if(!Pattern.matches("[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",employee.getEmailAddress())) {
			errmsg+="Please Enter a Valid Email Address\n";
			ferr = true;
		}
		if(ferr) {
			return new ResponseEntity(errmsg,HttpStatus.NOT_ACCEPTABLE);
		}else {
			employee.setEmpid(id);
			employeeservice.update(employee);
			return ResponseEntity.ok("Employee Data Updated Successfully");
		}
		
		
		
	}
	
	
	@DeleteMapping("/Employeee/{id}")
	public ResponseEntity<String>  delete(@PathVariable int id) {
		employeeservice.delete(id);
		return ResponseEntity.ok("Employee Data Deleted Successfully");
	}

}
