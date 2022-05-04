package com.cogent.empms.dto;

import java.time.LocalDate;

import com.cogent.empms.exceptions.InvalidEmpIdException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@NoArgsConstructor
public class Employee {

	// boss don't create a setter method for empId
	@Setter(value = AccessLevel.NONE)
	private String empId;     // 2 inside the constructor , inside the setter method.
	
	private String empFirstName;
	private String empLastName;
	private String address;
	private float empSalary; // are we suppose to provide -ve salary=====> InvalidSalaryException
	private int departmentId;
	private LocalDate dob;
	private LocalDate doj;
	public void setEmpId(String empId) throws InvalidEmpIdException  {
		// empid is null or ''
		if(empId.equals("") || empId==null) {
			throw new InvalidEmpIdException("empid is null or blank ");
		}
		this.empId = empId;
	}
	public Employee(String empId, String empFirstName, String empLastName, String address, float empSalary,
			int departmentId, LocalDate dob, LocalDate doj) throws InvalidEmpIdException {
		super();
		this.setEmpId(empId);
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.address = address;
		this.empSalary = empSalary;
		this.departmentId = departmentId;
		this.dob = dob; // invalidDateException===> should be raised when age diff between dob and today's date is less than 22
		this.doj = doj;
	}
	
}
