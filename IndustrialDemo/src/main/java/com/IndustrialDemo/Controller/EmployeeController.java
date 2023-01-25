package com.IndustrialDemo.Controller;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;
import com.IndustrialDemo.Services.ServiceIMPL;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceIMPL impl;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/create")
	public String info() {
		return "hello world..";
	}
	
//	@GetMapping("/employees")
//	public List<Employee> getEmployees(){
//		return impl.getallEmployees()
//		
//	}
	
	@PostMapping(value = "/employee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestDTO> addEmployee(@RequestBody RequestDTO rdt) {

		impl.saveData(rdt);
		
		return new ResponseEntity<RequestDTO>(HttpStatus.OK);
		
	}
}
