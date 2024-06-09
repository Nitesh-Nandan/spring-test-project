package com.nitesh.spring_test_project.transitive;

import org.springframework.stereotype.Component;

@Component
public class ServiceC {
    public String call() {
        System.out.println("Executed in Service C");
        return "ServiceC";
    }
}
