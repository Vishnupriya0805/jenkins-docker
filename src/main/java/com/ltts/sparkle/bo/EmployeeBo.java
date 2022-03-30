package com.ltts.sparkle.bo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltts.sparkle.model.Employee;

@Repository
public interface EmployeeBo extends JpaRepository<Employee,Integer> {	
	
	
}
