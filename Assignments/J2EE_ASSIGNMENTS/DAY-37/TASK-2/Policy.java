package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Policy {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotBlank(message = "Policy name cannot be blank")
    private String name;
 
    @NotNull(message = "Policy type cannot be null")
    private PolicyType type;
 
    // getters and setters
}

class PolicyType {
    // Add your fields and methods here
}