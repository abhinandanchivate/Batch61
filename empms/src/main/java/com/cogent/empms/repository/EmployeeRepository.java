package com.cogent.empms.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.empms.dto.Employee;
import com.cogent.empms.exceptions.InvalidEmpIdException;

public interface EmployeeRepository {
	
	public Employee addEmployee(Employee employee) ;
	
	public Optional<Employee> getEmployeeById(String empId) throws Exception;
	
	public List<Employee> getEmployees();
	

}
