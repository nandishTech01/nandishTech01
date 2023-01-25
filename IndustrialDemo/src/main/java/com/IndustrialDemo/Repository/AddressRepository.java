package com.IndustrialDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IndustrialDemo.Entities.Database.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}
