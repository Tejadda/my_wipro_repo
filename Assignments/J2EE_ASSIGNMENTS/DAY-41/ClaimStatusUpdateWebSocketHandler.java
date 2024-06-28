package com.example.demo;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClaimStatusUpdateWebSocketHandler implements WebSocketHandler {
    
    private final ClaimStatusUpdateService claimStatusUpdateService;
    
    public ClaimStatusUpdateWebSocketHandler(ClaimStatusUpdateService claimStatusUpdateService) {
        this.claimStatusUpdateService = claimStatusUpdateService;
    }
    
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        URI uri = session.getHandshakeInfo().getUri();
        String claimIdStr = uri.getPath().split("/")[2]; // assuming the claimId is the second path segment
        Long claimId = Long.parseLong(claimIdStr); // parse the claimId from the URI path
        Flux<ClaimStatusUpdate> updates = claimStatusUpdateService.getUpdates(claimId);
        return session.send(updates.map(update -> session.textMessage(update.toString())));
    }
}