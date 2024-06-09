package com.nitesh.spring_test_project.transitive;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ServiceATest {

    @Mock
    private ServiceB serviceB;

    @InjectMocks
    private ServiceA serviceA;


    @Test
    void testCheckBeans() {
        Assertions.assertThat(serviceB).isNotNull();
        Assertions.assertThat(serviceA).isNotNull();
        Assertions.assertThat(serviceB.getServiceC()).isNotNull();
    }
}