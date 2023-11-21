package org.example.employee;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.employee.Main.deserialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void isSalaryDeserialization() {
        List<Employee> deserializationEmployee = deserialization("Employees.txt");
        for (Employee e: deserializationEmployee) {
            assertEquals(0, e.getSalary());
        }
    }


}