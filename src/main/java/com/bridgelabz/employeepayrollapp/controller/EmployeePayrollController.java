package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController 
{
		@Autowired(required = true)
		private IEmployeePayrollService employeePayrollService;
		
		@RequestMapping(value = {"","/","/get"})
		public ResponseEntity<ResponseDTO> getEmployeePayrollData()
		{
			List<EmployeePayrollData> empDataList = null;
			empDataList = employeePayrollService.getEmployeePayrollData();
			ResponseDTO resDTO = new ResponseDTO("Get Call Successful", empDataList);
			return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
		}
		@GetMapping("/get/{empId}")
		public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
		{
			EmployeePayrollData empData = null;
			empData = employeePayrollService.getEmployeePayrollDataById(empId);
			ResponseDTO resDTO = new ResponseDTO("Get Call For ID Successful", empData);
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
		}
		@PostMapping("/create")
		public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO)
		{
			EmployeePayrollData empData = null;
			empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
			ResponseDTO resDTO = new ResponseDTO("Create Employee Payroll Data Sucessfully :", empData);
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
		}
		@PutMapping("/update/{empId}")
		public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO)
		{
			
			EmployeePayrollData empData = null;
			empData = employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
			ResponseDTO resDTO = new ResponseDTO("Update Employee Payroll Data Sucessfully :", empData);
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
		}
		@DeleteMapping("/delete/{empId}")
		public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
		{
			employeePayrollService.deleteEmployeePayrollData(empId);
			ResponseDTO resDTO = new ResponseDTO("Delete Sucessfully","Deleted Id: " +empId);
			return new ResponseEntity<ResponseDTO>(resDTO,HttpStatus.OK);
		}
}
