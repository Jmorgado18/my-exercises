package com.exemplo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/api/hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}