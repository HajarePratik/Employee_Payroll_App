package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	public List<EmployeePayrollData> getEmployeePayrollData();
	
	public EmployeePayrollData getEmployeePayrollDataById(int empId);
	
	public List<EmployeePayrollData> getEmployeeByDepartment(String department);
	
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);
	
	public void deleteEmployeePayrollData(int empId);
	
}
