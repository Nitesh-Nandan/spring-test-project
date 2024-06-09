package com.nitesh.spring_test_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitesh.spring_test_project.model.Employee;
import com.nitesh.spring_test_project.service.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private EasyRandom easyRandom;


    @BeforeEach
    void setup() {
        easyRandom = new EasyRandom();
    }

    @Test
    void checkBeansInitialisation() {
        assertThat(mockMvc).isNotNull();
        assertThat(employeeService).isNotNull();
        assertThat(objectMapper).isNotNull();
    }

    @Test
    public void saveEmployeeController() throws Exception {
        Employee employee = easyRandom.nextObject(Employee.class);

        BDDMockito.given(employeeService.createEmployee(ArgumentMatchers.any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee))
        );

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())));
    }
}