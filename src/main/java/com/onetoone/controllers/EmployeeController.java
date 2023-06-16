package com.onetoone.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.models.Employee;
import com.onetoone.responseHandlers.ResponseHandler;
import com.onetoone.responses.EmployeeResponse;
import com.onetoone.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    ResponseEntity<Object> findAll() {
        List<EmployeeResponse> employeResponses = new ArrayList<>();
        employeeService.findAllEmployees().forEach(employee -> {
            employeResponses.add(new EmployeeResponse(employee));
        });;

        return  ResponseHandler.ok(employeResponses);
    }

    @PostMapping
    ResponseEntity<Employee> save(@Validated @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> find(@PathVariable(value = "id") Long id) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        if (employee.isPresent()) {
            EmployeeResponse employeeResponse = new EmployeeResponse(employee.get());
            return ResponseHandler.ok(employeeResponse);
        } else {
            return ResponseHandler.notFound();
        }

    }

    @PutMapping("/{id}")
    ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        Optional<Employee> savedEmployee = employeeService.findEmployeeById(id);
        if(savedEmployee.isPresent()){
            employee.setId(id);
            Employee updatedEmployee =employeeService.saveEmployee(employee);
            return ResponseHandler.updated(updatedEmployee);
        } else{
            return  ResponseHandler.notFound();
        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseHandler.deleted();
    }
}