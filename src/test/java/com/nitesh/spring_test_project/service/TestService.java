package com.nitesh.spring_test_project.service;

import com.nitesh.spring_test_project.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class TestService {

    @Autowired
    private HelloWorldService helloWorldService;

    @BeforeEach
    void runEveryTime() {
        System.out.println("Before each is executed");
    }

    @Test
    void testInjectedComponentsAreNotNull() {
        assertThat(helloWorldService).isNotNull();
    }

    @Test
    void testIfHeGreet() {
        var name = "Nitesh Nandan";

        var res = helloWorldService.greetMee(name);
        System.out.println(res);

        assertThat(res).contains(name);
    }

    @Test
    void testObject() {
        Employee emp = Employee.create(1L, "Nitesh", "Nanddan", "abc@com");
        Employee emp2 = Employee.builder().build();
        assertThat(emp).isNotEqualTo(emp2);
    }

    @Test
    void testAssertNull() {
        String name = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Assert.notNull(name, "Name Can't be Null");
        });
    }
}
