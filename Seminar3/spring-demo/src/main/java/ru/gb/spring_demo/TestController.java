package ru.gb.spring_demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
    @GetMapping("/resource/{resourceName}")
    public String tectResource(@PathVariable String resourceName){
        System.out.println(resourceName);
        return "ok";
    }
}
