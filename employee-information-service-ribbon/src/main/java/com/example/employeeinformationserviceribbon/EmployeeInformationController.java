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

    public EmployeeInformationController(RestTemplate restTemplate) {
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

    @DeleteMapping("/{id}")
    public Response delEmployee(@PathVariable(value = "id") int id) {
        return delEmployees(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") int id) {
        return updateEmployees(employee,id);
    }

    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> exchange = this.restTemplate.exchange(
                "http://EMPLOYEESERVICE/api/v1/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

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

    public Response delEmployees(int id) {
        HttpEntity<Integer> request = new HttpEntity<>(id);
        ResponseEntity<Response> exchange = this.restTemplate.exchange(
                String.format("http://EMPLOYEESERVICE/api/v1/employees/%s", id),
                HttpMethod.DELETE,
                null,
                Response.class);

        return exchange.getBody();
    }
    public Employee updateEmployees(Employee employee, int id) {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        ResponseEntity<Employee> exchange = this.restTemplate.exchange(
                String.format("http://EMPLOYEESERVICE/api/v1/employees/%s", id),
                HttpMethod.PUT,
                request,
                Employee.class);

        return exchange.getBody();
    }
}
