package com.example.demo;

//ClaimStatusUpdateService.java
import reactor.core.publisher.Flux;

public interface ClaimStatusUpdateService {
 Flux<ClaimStatusUpdate> getUpdates(Long claimId);
}