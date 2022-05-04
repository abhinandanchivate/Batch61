package com.cogent.empms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	private int departmentId;
	private String deptName;
	private String deptLocation;
}
