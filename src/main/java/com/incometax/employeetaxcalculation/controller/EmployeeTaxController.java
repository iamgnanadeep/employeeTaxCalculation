package com.incometax.employeetaxcalculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incometax.employeetaxcalculation.model.Employee;
import com.incometax.employeetaxcalculation.model.EmployeeTaxDetails;
import com.incometax.employeetaxcalculation.service.EmployeeTaxService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

/**
 * This class calculates tax details and adds employee details
 * 
 * @author Gnanadeep Vetukuri
 *
 */
@RestController
@RequestMapping("api")
public class EmployeeTaxController {

	@Autowired
	EmployeeTaxService empTaxService;

	/**
	 * Method to add Employee Details
	 * 
	 * @param employee
	 * @return {ResponseEntity}
	 */
	@GetMapping("/employee")
	public ResponseEntity<String> addEmployeeDetails(final @Valid @RequestBody Employee employee) {
		int empId = empTaxService.saveEmployee(employee);
		return ResponseEntity.ok("Employee Created with ID :" + empId);
	}

	/**
	 * Method to calculate tax details
	 * @param financialYear
	 * @return {ResponseEntity}
	 */
	@PostMapping("/employee")
	public ResponseEntity<List<EmployeeTaxDetails>> employeeTaxCalculator(
			final @RequestParam("financialYear") @Pattern(regexp = "\\d{4}") String financialYear) {
		List<EmployeeTaxDetails> employeeTaxDetailsList = empTaxService.calculateEmployeeTaxDetails(financialYear);
		return ResponseEntity.ok(employeeTaxDetailsList);
	}

}
