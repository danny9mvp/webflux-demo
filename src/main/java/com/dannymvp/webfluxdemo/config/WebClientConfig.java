package com.dannymvp.webfluxdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${com.dannymvp.webfluxdemo.jsonplaceholder.baseUrl}")
    private String baseUrl;

    @Value("${com.dannymvp.webfluxdemo.jsonplaceholder.usersUrl}")
    private String usersUrl;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.create(String.format("%s%s", baseUrl, usersUrl));
    }
}
