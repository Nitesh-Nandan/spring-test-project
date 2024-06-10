package com.nitesh.spring_test_project.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitesh.spring_test_project.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerITests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void clearRecords() {
        employeeRepository.deleteAll();
    }

    @Test
    void testSetup() {
        Assertions.assertThat(mockMvc).isNotNull();
        Assertions.assertThat(objectMapper).isNotNull();
        Assertions.assertThat(employeeRepository).isNotNull();
    }
}
