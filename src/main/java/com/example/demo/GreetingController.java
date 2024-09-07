package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// @ means we are not building a web application with html pages, whatever we returning from the controler
// we want it to be JSON or payload
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

      // single Method -Greeting

    @RequestMapping (method = RequestMethod.GET, path = "/greeting")
    //This Method expects in the url a param
    Greeting greeting (@RequestParam(defaultValue = "World") String name){
        return new Greeting (counter.incrementAndGet(), String.format(template, name));
    }


}
