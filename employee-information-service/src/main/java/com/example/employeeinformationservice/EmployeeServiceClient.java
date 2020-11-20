package com.example.employeeinformationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("EMPLOYEESERVICE")
public interface EmployeeServiceClient {

    @GetMapping("/api/v1/employees")
    List<Employee> getAll();

}
