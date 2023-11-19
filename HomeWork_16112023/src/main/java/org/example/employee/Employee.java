package org.example.employee;

import java.time.LocalDate;

public class Employee {
 String name;
 String lastName;
 LocalDate birth;
 String position;
 double salary;

    public Employee(String name, String lastName, LocalDate birth, String position, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + name + " " + lastName + " ; date of birth= " + birth +
                "; position= " + position + "; salary= " + salary + '}';
    }

    public String toStringWithoutSalary() {
        return "Employee{" + name + " " + lastName + " ; date of birth= " + birth +
                "; position= " + position + '}';
    }
}
//Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность, заработная плата. Сериализуйте объект
// и сохраните в файл. Поле заработной платы сериализовать не нужно, т.к. это коммерческая тайна организации.