package com.IndustrialDemo.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IndustrialDemo.Entities.Database.Address;
import com.IndustrialDemo.Entities.Database.Department;
import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;
import com.IndustrialDemo.Repository.AddressRepository;
import com.IndustrialDemo.Repository.DepartmentRepository;
import com.IndustrialDemo.Repository.EmployeeRepository;

@Service
public class ServiceIMPL implements Services{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressrepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired	
	private ModelMapper modelmapper;
	
	

	public ServiceIMPL(EmployeeRepository employeeRepository, AddressRepository addressrepository,
			DepartmentRepository departmentRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.addressrepository = addressrepository;
		this.departmentRepository = departmentRepository;
	}

	
	public RequestDTO create(RequestDTO rdt) {
		Employee employee = new Employee();
		
		return rdt;
		
	}

	public List<Employee> getallEmployees() {
		return employeeRepository.findAll();
	}

	
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public void saveData(RequestDTO requestDTO) {
		Employee emp = Employee.builder()
				.firstname(requestDTO.getFirstname())
				.lastname(requestDTO.getLastname())
				.code(requestDTO.getCode())
				.mobile(requestDTO.getMobile())
				.build();
		
		Address add = Address.builder()
				.address(requestDTO.getAddress())
				.employee(emp)
				.build();
		//addressrepository.save(add);
		
		
		Department dept = Department.builder()
				.Subdepartment(requestDTO.getSubdepartment())
				.departmentname(requestDTO.getDepartment())
				.employee(emp)//0 - id
				.build();

		//departmentRepository.save(dept);
		
		Set<Department> departmentSet = new HashSet();
		departmentSet.add(dept);
		
		Set<Address> addressset = new HashSet<>();
		addressset.add(add);
		
		emp.setAddress(addressset);
		emp.setDepartment(departmentSet);
		Employee e  = employeeRepository.save(emp);//id
		
	}

	
		
	}


