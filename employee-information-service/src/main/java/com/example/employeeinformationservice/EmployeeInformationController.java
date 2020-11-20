package com.example.employeeinformationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee-information")
public class EmployeeInformationController {

    private final EmployeeServiceClient employeeServiceClient;

    public EmployeeInformationController(EmployeeServiceClient employeeServiceClient) {
        this.employeeServiceClient = employeeServiceClient;
    }

    @GetMapping
    public List<Employee> getAll(){
        return this.employeeServiceClient.getAll();
    }
}
