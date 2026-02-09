package com.example.flux.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveHandler {
    public Mono<ServerResponse> handler() {
        Flux<String> publisher = Flux.just("s","k","k");
        Mono<ServerResponse> serverResponseMono =
                ServerResponse.ok()
                        .body(publisher,String.class);
        return serverResponseMono;
    }
}
