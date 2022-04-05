package com.ltts.sparkle.test;



import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ltts.sparkle.bo.EmployeeBo;
import com.ltts.sparkle.model.Employee;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class employeetest {

	@Autowired
	EmployeeBo eb;
	
	@Test
	@Order(1)
	public void testCreate() {
		Employee e = new Employee();
		e.setEmpid(2);
		e.setEmpName("Priya");
		e.setEmailAddress("abc@gmail.com");
		e.setGender("Female");
		e.setSalary("50000");
		e.setMobile("9087689546");
		eb.save(e);
		assertNotNull(eb.findById(2).get());
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		List<Employee> l = eb.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testUpdate() {
		Employee e2 = eb.findById(2).get();
		e2.setSalary("40000");
		eb.save(e2);
		assertNotEquals(40000,eb.findById(2).get().getSalary());
	}
	
	@Test
	@Order(4)
	public void testDelete () {
		eb.deleteById(2);
		assertThat(eb.existsById(2)).isFalse();
		
	}
	
}
