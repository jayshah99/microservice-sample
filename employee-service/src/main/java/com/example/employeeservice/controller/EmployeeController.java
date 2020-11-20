package com.example.employeeservice.controller;

import com.example.employeeservice.resource.model.Employee;
import com.example.employeeservice.resource.pojo.Response;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable(value = "id") int id) {
        return employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee updateById(@RequestBody Employee employee, @PathVariable("id") int id) {
        return employeeService.updateById(employee, id);
    }
}
