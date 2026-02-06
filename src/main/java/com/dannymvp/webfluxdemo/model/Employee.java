package com.dannymvp.webfluxdemo.model;

public record Employee(Long id, String name, String username, String email, Address address, String phone, String website, Company company) {
}
