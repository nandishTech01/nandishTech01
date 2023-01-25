package com.IndustrialDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IndustrialDemo.Entities.Database.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
