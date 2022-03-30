package com.ltts.sparkle.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import com.ltts.sparkle.bo.EmployeeBo;
import com.ltts.sparkle.model.Employee;
import com.ltts.sparkle.service.EmployeeService;

@SpringBootTest

  public class SparkleApplicationTest {
	
	@InjectMocks
	EmployeeService service;

	@Mock
	EmployeeBo employeebo;

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		
		}
	
	@Test
	public void employeetest() {
		List<Employee> list = new ArrayList<Employee>();
		Employee empOne = new Employee(1,"Vj@gmail.com","priya","Female","8733653730","50000");
		Employee empTwo = new Employee(2,"chi@gmail.com","chikki","Female","8700053730","40000");
		list.add(empOne);
		list.add(empTwo);
		when(employeebo.findAll()).thenReturn(list);
		List<Employee> empList = service.Employeelist();
		assertEquals(2, empList.size());
	}
}

	