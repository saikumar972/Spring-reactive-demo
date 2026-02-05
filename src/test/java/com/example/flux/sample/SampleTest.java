package com.example.flux.sample;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> publisher = getPublisher();
        publisher.subscribe(System.out::println);
        Thread.sleep(10000);
    }

    private static Flux<String> getPublisher() {
        return Flux.just("s","a","i","k").delayElements(Duration.ofSeconds(1));

    }

}
