package com.dannymvp.webfluxdemo.rest;

import com.dannymvp.webfluxdemo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeRestClient {

    private final WebClient client;

    public EmployeeRestClient(WebClient client) {
        this.client = client;
    }

    public Mono<Employee> getEmployeeById(Long id) {
        return client.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    public Flux<Employee> getAllEmployees() {
        return client.get()
                .uri("/")
                .retrieve()
                .bodyToFlux(Employee.class);
    }
}
