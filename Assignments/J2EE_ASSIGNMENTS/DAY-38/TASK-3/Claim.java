package com.example.demo1;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Claim {
    @NotNull
    @Size(min = 2, max = 50)
    private String name;
    
    @NotNull
    @Email
    private String email;
    
    // getters and setters
}
