package task3School.school;

import task3School.subject.Subject;

public class StudentToSubject <Student, S extends Subject>{
    Student student;
    S subject;

    public StudentToSubject(Student student, S subject) {
        this.student = student;
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public S getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "\n Subject: " + subject +
                "; student: " + student ;
    }
}
