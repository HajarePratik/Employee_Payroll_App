package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee Name cannot be Correct")
	public String name;
	
	@Min(value = 500, message = "Min Wage should be more than 500")
	public long salary;

	//@JsonFormat(pattern="ddMMMyyyy")
	@NotEmpty(message = "startDate should Not be Empty")
	@PastOrPresent(message = "startDate should be past or todays date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate startDate;
	
	@Pattern(regexp= "male|female",message = "Gender needs to be male or female")
	public String gender;
	
	@NotBlank(message = "Note cannot be Empty")
	public String note;
	
	@NotBlank(message = "profilePic cannot be Empty")
	public String profilePic;
	
	@NotNull(message = "department should Not be Empty")
	public List<String> department;
	
	
	
	
	
}
