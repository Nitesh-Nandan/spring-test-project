package com.nitesh.spring_test_project.transitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    @Autowired
    private ServiceB serviceB;
}
