package com.onetoone.springboot.contollers;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onetoone.models.Employee;
import com.onetoone.repositories.EmployeeRepository;
import com.onetoone.springboot.SpringBootOneToOneApplication;
import com.onetoone.springboot.assets.EmployeeAsset;

@ActiveProfiles(value = { "test" })
@SpringBootTest(classes = SpringBootOneToOneApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ObjectMapper objectMapper;

    // @Autowired
    // EmployeeAsset employeeAsset;

    @Test
    public void createEmployee_returnEmployee()  {
        EmployeeAsset employeeAsset = new EmployeeAsset();
        Employee employee = employeeAsset.createEmployee1();

        try {
            RequestBuilder postRequest = MockMvcRequestBuilders.post("/employee")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(employee));

            ResultActions resultActions = mockMvc.perform(postRequest);
            resultActions.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value((employee.getFirstName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value((employee.getLastName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.email").value((employee.getEmail())));

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findEmployeeById_returnEmployee() throws Exception {
        EmployeeAsset employeeAsset = new EmployeeAsset();
        Employee employee = employeeAsset.createEmployee2();
        Employee dbEmployee = employeeRepository.save(employee);

        try {
            RequestBuilder getRequest = MockMvcRequestBuilders.get("/employee/{id}", 2);
            ResultActions resultActions = mockMvc.perform(getRequest);
            resultActions.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value((dbEmployee.getFirstName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value((dbEmployee.getLastName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.email").value((dbEmployee.getEmail())))

            ;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void updateEmployeeById_returnEmployee() throws Exception {
        EmployeeAsset employeeAsset = new EmployeeAsset();
        Optional<Employee> searchEmployee = employeeRepository.findById((long) 1);
        Employee dbEmployee = null;

        if (searchEmployee.isPresent()) {
            dbEmployee = searchEmployee.get();
        } else {
            dbEmployee = employeeRepository.save(employeeAsset.createEmployee1());
        }
        dbEmployee.setFirstName("Jayadi");

        try {
            RequestBuilder putRequest = MockMvcRequestBuilders.put("/employee/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(dbEmployee));

            ResultActions resultActions = mockMvc.perform(putRequest);
            resultActions.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value((dbEmployee.getFirstName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value((dbEmployee.getLastName())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.email").value((dbEmployee.getEmail())));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deleteEmployeeById_returnSuccess(){
        try{
            RequestBuilder deleteRequest = MockMvcRequestBuilders.delete("/employee/{id}",  2);
            ResultActions resultActions = mockMvc.perform(deleteRequest);
            resultActions.andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
}
