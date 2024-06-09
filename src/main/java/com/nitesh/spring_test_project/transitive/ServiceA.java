package com.nitesh.spring_test_project.transitive;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
