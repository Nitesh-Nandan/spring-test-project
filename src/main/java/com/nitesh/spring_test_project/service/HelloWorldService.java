package com.nitesh.spring_test_project.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String greetMee(String name) {
        return String.format("Hello %s", name);
    }

}
