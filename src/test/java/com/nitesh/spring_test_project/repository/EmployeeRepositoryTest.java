package com.nitesh.spring_test_project.repository;

import com.nitesh.spring_test_project.model.Employee;
import com.nitesh.spring_test_project.service.HelloWorldService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ExtendWith(SpringExtension.class)
class EmployeeRepositoryTest {

    @Mock
    private HelloWorldService helloWorldService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private EasyRandom generator;

    @BeforeEach
    void init() {
        generator = new EasyRandom();
    }

    @Test
    void testInjectedBeansAreNotNull() {
        assertThat(helloWorldService).isNotNull();
        assertThat(employeeRepository).isNotNull();
        assertThat(generator).isNotNull();
    }

    @Test
    void givenEmployeeWhenSaveReturnSavedEmployee() {
        var emp = generator.nextObject(Employee.class);
        emp.setId(null);

        var savedEmp = employeeRepository.save(emp);

        assertThat(savedEmp).isNotNull();
        assertThat(savedEmp.getId()).isGreaterThan(0);
        assertThat(savedEmp.getEmail()).isEqualTo(emp.getEmail());
        assertThat(savedEmp.getFirstName()).isEqualTo(emp.getFirstName());
        assertThat(savedEmp.getLastName()).isEqualTo(emp.getLastName());
    }

    @Test
    void testFetchAllEmployees() {
        var employees = generator.objects(Employee.class, 5).toList();
        employees.forEach(emp -> emp.setId(null));

       employeeRepository.saveAll(employees);

       var savedEmp = employeeRepository.findAll();

       assertThat(savedEmp).isNotNull();
       assertThat(savedEmp.size()).isEqualTo(employees.size());
    }

    @Test
    void testEmployeeFindById() {
        var emp = generator.nextObject(Employee.class);
        emp.setId(null);

        employeeRepository.save(emp);

        var savedEmp = employeeRepository.findById(emp.getId()).get();

        assertThat(savedEmp).isNotNull();
    }
}