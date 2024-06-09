package com.nitesh.spring_test_project.transitive;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {

    private ServiceC serviceC;

    public ServiceB(ServiceC serviceC) {
        this.serviceC = serviceC;
    }

    public ServiceC getServiceC() {
        return serviceC;
    }
}
