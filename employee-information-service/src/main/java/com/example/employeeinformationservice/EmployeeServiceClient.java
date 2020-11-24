package com.example.employeeinformationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("EMPLOYEESERVICE")
public interface EmployeeServiceClient {

    @GetMapping("/api/v1/employees")
    List<Employee> getAll();

    @PostMapping("/api/v1/employees")
    Employee addEmployee(Employee employee);

    @DeleteMapping("/api/v1/employees/{id}")
    Response delEmployee(@PathVariable(value = "id") int id);

    @PutMapping("/api/v1/employees/{id}")
    Employee updateEmployee(Employee employee, @PathVariable(value = "id") int id );
}
