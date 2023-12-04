package com.incometax.employeetaxcalculation.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.incometax.employeetaxcalculation.model.Employee;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes= {EmployeeTaxControllerTests.class})
public class EmployeeTaxControllerTests {
	@Mock
 	EmployeeTaxController controller;
	
	@Test
	public void testAddEmployeeDetails() {
		Mockito.when(controller.addEmployeeDetails(Mockito.any(Employee.class))).thenReturn(ResponseEntity.ok("Employee Created with ID :" + 01));
	}

}
