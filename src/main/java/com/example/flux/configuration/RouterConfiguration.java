package com.example.flux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class RouterConfiguration {
    @Bean
    RouterFunction<ServerResponse> routerConfig() {
        RequestPredicate requestPredicate = RequestPredicates.GET("/hello");
        HandlerFunction<ServerResponse> handlerFunction = new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                Flux<String> publisher = Flux.just("sai","kumar","reactive").delayElements(Duration.ofSeconds(1));
                return ServerResponse
                        .ok()
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(publisher, String.class);
            }
        };

        RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(requestPredicate,handlerFunction);
        return routerFunction;

    }
}
