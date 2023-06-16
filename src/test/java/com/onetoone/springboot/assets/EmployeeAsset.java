package com.onetoone.springboot.assets;

import com.onetoone.models.Employee;

public class EmployeeAsset {

    public Employee createEmployee1(){
        return new Employee("Rio", "Wijaya", "rio@email.com");
    }

    public Employee createEmployee2(){
        return new Employee("Surya", "Duabelas", "surya@email.com");
    }


}