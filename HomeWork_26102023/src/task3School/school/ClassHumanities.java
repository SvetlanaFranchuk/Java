package task3School.school;


import task3School.subject.Subject;
import task3School.subject.humanities.Humanities;

public class ClassHumanities <Student, S extends Humanities>{
    Student student;
    S subject;

    public ClassHumanities(Student student, S subject) {
        this.student = student;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ClassHumanities: " +
                " subject=" + subject +
                "; student" + student + "\n";
    }
}
