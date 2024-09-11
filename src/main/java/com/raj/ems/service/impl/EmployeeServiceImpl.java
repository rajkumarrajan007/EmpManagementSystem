package com.raj.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.raj.ems.dto.EmployeeDto;
import com.raj.ems.entity.Employee;
import com.raj.ems.exception.ResourceNotFoundException;
import com.raj.ems.mapper.EmployeeMapper;
import com.raj.ems.repository.EmployeeRepository;
import com.raj.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	
// constructor
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee); 
	}



	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		
		
		Employee employee=employeeRepository.findById(employeeId)
		                          .orElseThrow(() -> 
		                          new ResourceNotFoundException("Employee is not exist with given id :"+employeeId ));
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}



	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee>employees=employeeRepository.findAll();
		return employees.stream().map((employee) ->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
		
	}



	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatesEmployee) {
		// TODO Auto-generated method stub
		
		Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(() -> 
                new ResourceNotFoundException("Employee is not exist with given id :"+employeeId ));
		
		employee.setFirstName(updatesEmployee.getFirstName());
		employee.setLastName(updatesEmployee.getLastName());
		employee.setEmail(updatesEmployee.getEmail());
		
		
		Employee updatedEmployeeObj=employeeRepository.save(employee);

         return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
		
	}



	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub

		Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(() -> 
                new ResourceNotFoundException("Employee is not exist with given id :"+employeeId ));
		employeeRepository.deleteById(employeeId);
		
		
		
	}

}
