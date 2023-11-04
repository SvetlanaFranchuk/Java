package task3School.student;

import task3School.subject.Subject;

public class Student <S extends Subject> {
    private String lastname;

    private S subject;

    public Student(String lastname, S subject) {
        this.lastname = lastname;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return " lastname: " + lastname + " subject: " + subject +"\n";
    }
}
