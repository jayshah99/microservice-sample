package com.example.employeeinformationserviceribbon;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> exchange = this.restTemplate.exchange(
                "http://EMPLOYEESERVICE/api/v1/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        return exchange.getBody();
    }

}
