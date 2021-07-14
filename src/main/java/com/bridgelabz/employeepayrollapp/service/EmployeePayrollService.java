package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.respository.EmployeePayrollRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRespository employeeRespository;
	
	
	public List<EmployeePayrollData> getEmployeePayrollData() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}


	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		// TODO Auto-generated method stub
		return employeeRespository.findById(empId)
				.orElseThrow(()-> new EmployeePayrollException("Employee with employeeId " + empId + " does not exists...!"));
	}


	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		// TODO Auto-generated method stub
		EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);
		BeanUtils.copyProperties(empPayrollDTO,empData);
		log.debug("Emp Data:"+empData.toString());
		return employeeRespository.save(empData);
	}


	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		// TODO Auto-generated method stub
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeeRespository.save(empData);
		
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeeRespository.delete(empData);
		
	}


	@Override
	public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
		// TODO Auto-generated method stub
		return employeeRespository.findEmployeeByDepartment(department);
	}
	

}
