package io.codeforall.bootcamp;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET, value = "api/hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }
}