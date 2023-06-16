package com.onetoone.responses;

import com.onetoone.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String street;

    public EmployeeResponse(Employee employee) {
        this.setId(employee.getId());
        this.setCity(employee.getAddress().getCity());
        this.setStreet(employee.getAddress().getStreet());
        this.setFirstName(employee.getFirstName());
        this.setLastName(employee.getLastName());
        this.setEmail(employee.getEmail());
    }
}
