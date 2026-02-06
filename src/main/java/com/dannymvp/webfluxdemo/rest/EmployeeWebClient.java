package com.dannymvp.webfluxdemo.rest;

import com.dannymvp.webfluxdemo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeWebClient {
    private WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

    public Mono<Employee> getEmployeeById(Long id) {
        return client.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(Employee.class);
    }

    public Flux<Employee> getAllEmployees() {
        return client.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(Employee.class);
    }
}
