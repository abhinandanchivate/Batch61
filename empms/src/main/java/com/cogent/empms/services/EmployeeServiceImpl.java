package com.cogent.empms.services;

import com.cogent.empms.dto.Employee;
import com.cogent.empms.repository.EmployeeRepository;
import com.cogent.empms.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	// Singleton Design pattern
	// one 
	// DP : it is a common solution to common problem.
	
	private EmployeeRepository employeeRepository = EmployeeRepositoryImpl.getInstance();
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addEmployee(employee);
	}

}
