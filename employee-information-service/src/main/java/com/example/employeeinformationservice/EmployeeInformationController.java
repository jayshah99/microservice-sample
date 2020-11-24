package com.example.employeeinformationservice;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeServiceClient.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Response delEmployee(@PathVariable(value = "id") int id){
        return this.employeeServiceClient.delEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") int id){
        return this.employeeServiceClient.updateEmployee(employee, id);
    }
}
