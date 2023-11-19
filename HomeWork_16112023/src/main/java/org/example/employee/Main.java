package org.example.employee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Evered","Boyd", LocalDate.of(1990, 12,21), "manager", 2000 );
        Employee employee2 = new Employee("Bradley","Colon", LocalDate.of(1983, 1,12), "imageMarker", 1900 );
        Employee employee3 = new Employee("Jeffrey","Williams", LocalDate.of(1986, 2,17), "copywriter", 1500 );
        Employee employee4 = new Employee("Henry","Bradley", LocalDate.of(1994, 7,14), "marketer", 1700 );
        Employee employee5 = new Employee("William","Sanchez", LocalDate.of(1980, 6,8), "advertisingDirector", 2500 );

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        try {
            writeToFile(employees, new FileOutputStream("Employees.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void writeToFile(List<Employee> list, OutputStream output) {
        try (OutputStream output2 = new DataOutputStream(output)) {
            for (Employee oneStr : list)
                output2.write((oneStr.toStringWithoutSalary()+"\n").getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность, заработная плата. Сериализуйте объект
// и сохраните в файл. Поле заработной платы сериализовать не нужно, т.к. это коммерческая тайна организации.