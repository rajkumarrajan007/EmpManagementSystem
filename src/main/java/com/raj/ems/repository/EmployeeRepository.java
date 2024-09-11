package com.raj.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
