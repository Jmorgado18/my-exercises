package io.codeforall.fanstatics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("helloworld")
    public class HelloWorldController {

        @RequestMapping(method = RequestMethod.GET, value = "api/hello")
        public ResponseEntity<String>
        helloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

            return new ResponseEntity<String>("Hello " + str, HttpStatus.I_AM_A_TEAPOT);

        }
    }