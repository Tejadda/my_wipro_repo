package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//PolicyRepository.java
public interface PolicyRepository extends JpaRepository<Policy, Long> {
 // Add custom repository methods here, if needed
}
