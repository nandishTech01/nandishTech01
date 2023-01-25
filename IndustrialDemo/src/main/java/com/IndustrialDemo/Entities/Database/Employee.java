package com.IndustrialDemo.Entities.Database;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String mobile;
	
	private String code;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
	private Set<Address> address;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private Set<Department> department;
}
