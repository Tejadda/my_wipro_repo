package com.example.demo;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public void getProduct(@PathVariable Long id) {
        // Return a product object
    }
}