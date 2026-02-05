package com.example.flux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class ReactiveController {
    @GetMapping("/get")
    public List<String> getList() throws InterruptedException {
        List<String> sampleList = List.of("sai","kumar","katta");
        List<String> returnList = new ArrayList<>(List.of());
        for (String s: sampleList) {
            returnList.add(s);
            Thread.sleep(1000);
            System.out.println("The operation performed on "+Thread.currentThread().getName()+" "+"and added element was "+s);
        }
        return returnList;
    }

    @GetMapping("/getFlux")
    public Flux<String> getFlux() {
        List<String> sampleList = List.of("sai","kumar","katta");
        return Flux.fromIterable(sampleList).delayElements(Duration.ofSeconds(1)).log();
    }

}
