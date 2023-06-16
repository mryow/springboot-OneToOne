package com.onetoone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
