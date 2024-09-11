package com.raj.ems.service;

import java.util.List;

import com.raj.ems.dto.EmployeeDto;
import com.raj.ems.entity.Employee;

public interface EmployeeService {
	
	EmployeeDto  createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatesEmployee);
	
	void deleteEmployee(Long employeeId);

}
