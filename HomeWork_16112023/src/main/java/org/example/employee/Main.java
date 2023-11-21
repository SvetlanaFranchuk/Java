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

        serialization(employees,"Employees.txt");

        List<Employee> deserializationEmployee = deserialization("Employees.txt");
        for (Employee e: deserializationEmployee) {
            System.out.println(e);
        }

    }

    public static void serialization (List<Employee> employees, String fileName){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> deserialization(String path){
        List<Employee> employees = null;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            employees= (ArrayList) input.readObject();

          } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

}
//Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность, заработная плата. Сериализуйте объект
// и сохраните в файл. Поле заработной платы сериализовать не нужно, т.к. это коммерческая тайна организации.