package com.onetoone.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.onetoone.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    Optional<Employee> findByEmail(String email);

}  