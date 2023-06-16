package com.onetoone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.onetoone.models.Employee;
import com.onetoone.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
       
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
       
        Optional <Employee> dbEmployee = employeeRepository.findByEmail(employee.getEmail());

        if(dbEmployee.isPresent()){
            throw new DuplicateKeyException("Email " + employee.getEmail() +" already use");
        }

        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}
