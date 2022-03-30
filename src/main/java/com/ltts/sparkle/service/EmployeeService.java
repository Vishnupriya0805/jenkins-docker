package com.ltts.sparkle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.sparkle.bo.EmployeeBo;
import com.ltts.sparkle.model.Employee;


@Service
public class EmployeeService {
@Autowired
EmployeeBo employeebo;
	public List<Employee> Employeelist() {
		// TODO Auto-generated method stub
		return employeebo.findAll() ;
	}
	public Employee insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeebo.save(employee);
	}
	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return employeebo.save(employee);
	}
	public void delete(int id) {
		
		employeebo.deleteById(id);                                                                                                                                                       
	}
	 
}
