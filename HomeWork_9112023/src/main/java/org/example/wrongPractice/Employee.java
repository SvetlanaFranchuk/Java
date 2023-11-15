package org.example.wrongPractice;

import lombok.Getter;

import java.time.LocalDate;

//TODO нарушен принцип DRY. Можно было бы использовать библиотеку lombok со следующими аннотациями
//@Getter
//@AllArgsConstructor

public abstract class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private LocalDate birth;

    public Employee(int id, String firstName, String lastName, int salary, LocalDate birth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirth() {
        return birth;
    }

    //TODO следующие 2 метода - нарушение принципов SOLID:
    //TODO нарушен принцип единой ответственности - методы по формированию рабочих обязанностей и хобби лучше вынести в отдельный класс
    public void draftContract (){
        System.out.println("My work is drafting of contract");
    }

    public void hobbyMarathon(boolean isParticipants){
        System.out.println("My hobby is run of marathon");
    };
}
