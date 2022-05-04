package com.cogent.empms.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cogent.empms.dto.Employee;
import com.cogent.empms.exceptions.InvalidEmpIdException;
import com.cogent.empms.utils.DBUtils;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private EmployeeRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	private static EmployeeRepository employeeRepository;
	
	public static EmployeeRepository getInstance() {
	
		if(employeeRepository==null) {
			employeeRepository = new EmployeeRepositoryImpl();
		}
		return employeeRepository;
		
	}
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// duplicate empId ===> DuplicateEmpIdException.
		
		Connection connection = DBUtils.getConnection();
		String insertStatement = "insert into employee (empId, empFirstName, "
				+ "empLastName, address, empSalary , departmentId, "
				+ "dob, doj) values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			 preparedStatement = connection.prepareStatement
					(insertStatement);
			 preparedStatement.setString(1, employee.getEmpId());
			 preparedStatement.setString(2, employee.getEmpFirstName());
			 preparedStatement.setString(3, employee.getEmpLastName());
			 preparedStatement.setString(4, employee.getAddress());
			 preparedStatement.setDouble(5, employee.getEmpSalary());
			 preparedStatement.setInt(6, employee.getDepartmentId());
			 preparedStatement.setDate(7, Date.valueOf(employee.getDob()));
			 preparedStatement.setDate(8, Date.valueOf(employee.getDoj()));
			 
			 int result = preparedStatement.executeUpdate();
			 if(result>0) {
				 return employee;
			 }
			 // execute a boolean value : DDL
			 // executeUpdate will return no of rows affected : DML
			 // executeQuery : DQL will return RS
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return null;
	}
	@Override
	public Optional<Employee> getEmployeeById(String empId) throws InvalidEmpIdException {
		// TODO Auto-generated method stub
		
		String query = "select * from employee where empId=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, empId);
			resultSet = preparedStatement.executeQuery();
			// do we have the data or not?
			
		
			// if we are gettign max 1 rec =---> if 
			// otherwise we should go for while
			
			if(resultSet.next()) {
				// return w.r.t. Optional
				// do we need to build the optional object?
				employee = new Employee();
				employee.setEmpId(resultSet.getString("empId"));
				employee.setAddress(resultSet.getString("address"));
				employee.setDepartmentId(resultSet.getInt("departmentId"));
				employee.setDob(resultSet.getDate("dob").toLocalDate());
				employee.setDoj(resultSet.getDate("doj").toLocalDate());
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				//return Optional.of(employee);
				// throw an exception
			}
			else {
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return Optional.ofNullable(employee);
	}
	@Override
	public List<Employee> getEmployees() {
		// thorw no records
		String query = "select * from employee";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		ArrayList<Employee> list = new ArrayList<>();
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			
			//preparedStatement.setString(1, empId);
			resultSet = preparedStatement.executeQuery();
			// do we have the data or not?
			
		
			// if we are gettign max 1 rec =---> if 
			// otherwise we should go for while
			
			while(resultSet.next()) {
				// return w.r.t. Optional
				// do we need to build the optional object?
				employee = new Employee();
				employee.setAddress(resultSet.getString("address"));
				employee.setDepartmentId(resultSet.getInt("departmentId"));
				employee.setDob(resultSet.getDate("dob").toLocalDate());
				employee.setDoj(resultSet.getDate("doj").toLocalDate());
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				list.add(employee);
				//return Optional.of(employee);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return null;
	}

}
