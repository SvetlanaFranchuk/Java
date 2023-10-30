package task3School.student;

import task3School.subject.Subject;

public class Student {
    private String lastname;

    public Student(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return " lastname: " + lastname;
    }
}
