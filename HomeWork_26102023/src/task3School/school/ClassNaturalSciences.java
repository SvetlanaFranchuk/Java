package task3School.school;


import task3School.subject.naturalSciences.NaturalSciences;

public class ClassNaturalSciences<Student, S extends NaturalSciences>{
    Student student;
    S subject;

    public ClassNaturalSciences(Student student, S subject) {
        this.student = student;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ClassNaturalSciences: " +
                " subject=" + subject +
                "; student" + student + "\n";
    }
}
