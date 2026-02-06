package com.dannymvp.webfluxdemo.service;

import com.dannymvp.webfluxdemo.model.Employee;
import com.dannymvp.webfluxdemo.rest.EmployeeRestClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRestClient employeeRestClient;

    public EmployeeService(EmployeeRestClient employeeRestClient) {
        this.employeeRestClient = employeeRestClient;
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRestClient.getEmployeeById(id);
    }

    public Flux<Employee> getAllEmployees() {
        return employeeRestClient.getAllEmployees();
    }
}
