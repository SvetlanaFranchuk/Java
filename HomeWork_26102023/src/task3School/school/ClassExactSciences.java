package task3School.school;


import task3School.subject.exactSciences.ExactSciences;

public class ClassExactSciences<Student, S extends ExactSciences>{
    Student student;
    S subject;

    public ClassExactSciences(Student student, S subject) {
        this.student = student;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ClassExactSciences: " +
                " subject=" + subject +
                "; student" + student + "\n";
    }
}
