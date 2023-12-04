package com.incometax.employeetaxcalculation.service;

import java.util.List;

import com.incometax.employeetaxcalculation.model.Employee;
import com.incometax.employeetaxcalculation.model.EmployeeTaxDetails;

/**
 * Interface for Employee Details and Tax calculator
 * @author Gnanadeep Vetukuri
 *
 */
public interface EmployeeTaxService {

	public int saveEmployee(final Employee emp);
	 
	public List<EmployeeTaxDetails> calculateEmployeeTaxDetails(final String financialYear);
	
}
