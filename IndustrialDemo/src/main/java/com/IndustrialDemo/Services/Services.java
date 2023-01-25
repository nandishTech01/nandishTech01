package com.IndustrialDemo.Services;

import java.util.List;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;

public interface Services  {
	
	List<Employee> getallEmployees();
	
	Employee createEmployee(Employee e);

	
	
	
	
}
