package com.example.employeeinformationserviceribbon;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("employee-information")
public class EmployeeInformationController {

    private final RestTemplate restTemplate;

    public EmployeeInformationController( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Employee> getALl() {
        return getEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return addEmployees(employee);
    }

    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> exchange = this.restTemplate.exchange(
                "http://EMPLOYEESERVICE/api/v1/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }
    public Employee addEmployees(Employee employee) {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        ResponseEntity<Employee> exchange = this.restTemplate.exchange(
                "http://EMPLOYEESERVICE/api/v1/employees",
                HttpMethod.POST,
                request,
                Employee.class);

        return exchange.getBody();
    }
}
