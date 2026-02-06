package com.dannymvp.webfluxdemo.service;

import com.dannymvp.webfluxdemo.model.Employee;
import com.dannymvp.webfluxdemo.rest.EmployeeWebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeWebClient employeeWebClient;

    public EmployeeService(EmployeeWebClient employeeWebClient) {
        this.employeeWebClient = employeeWebClient;
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return employeeWebClient.getEmployeeById(id);
    }

    public Flux<Employee> getAllEmployees() {
        return employeeWebClient.getAllEmployees();
    }
}
