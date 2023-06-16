package com.onetoone.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetoone.models.Address;
import com.onetoone.models.Employee;
import com.onetoone.repositories.AddressRepository;
import com.onetoone.repositories.EmployeeRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Address save(Long employeeId, Address address){
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            address.setEmployee(employee.get());
        }else{
            throw new NoSuchElementException("not found");
        }

        return addressRepository.save(address);
    }

    public Address save(Employee employee, Address address){
        address.setEmployee(employee);
        return addressRepository.save(address);
    }

    
}
