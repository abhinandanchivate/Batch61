package com.cogent.empms;

import java.time.LocalDate;
import java.util.Properties;

import com.cogent.empms.dto.Employee;
import com.cogent.empms.services.EmployeeService;
import com.cogent.empms.services.EmployeeServiceImpl;
import com.cogent.empms.utils.DBUtils;

public class Main {
	
	public static void main(String[] args) {
	//	Properties properties = DBUtils.
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		Employee employee  = new Employee("ab001","abhi","chivate","Mumbai",
				1000.0f,1,LocalDate.of(1988, 12, 9),LocalDate.now());
		
		Employee employee2 = employeeService.addEmployee(employee);
		
		System.out.println(employee2);
	}

}
