package com.example.demo;
//ClaimStatusUpdateHandler.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/claim-status")
public class ClaimStatusUpdateHandler {

 private final ClaimStatusUpdateService claimStatusUpdateService;

 public ClaimStatusUpdateHandler(ClaimStatusUpdateService claimStatusUpdateService) {
     this.claimStatusUpdateService = claimStatusUpdateService;
 }

 @GetMapping(value = "/{claimId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
 public Flux<ClaimStatusUpdate> getClaimStatusUpdates(@PathVariable Long claimId) {
     // Return a Flux of ClaimStatusUpdate objects
     return claimStatusUpdateService.getUpdates(claimId);
 }
}