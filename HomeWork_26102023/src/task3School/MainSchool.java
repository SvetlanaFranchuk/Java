package task3School;

import task3School.school.ClassExactSciences;
import task3School.school.ClassHumanities;
import task3School.school.ClassNaturalSciences;
import task3School.student.Student;
import task3School.student.StudentExactSciences;
import task3School.student.StudentHumanities;
import task3School.student.StudentNaturalSciences;
import task3School.subject.exactSciences.ExactSciences;
import task3School.subject.humanities.Humanities;
import task3School.subject.naturalSciences.Biology;
import task3School.subject.naturalSciences.Chemistry;
import task3School.subject.exactSciences.Mathematics;
import task3School.subject.exactSciences.Physics;
import task3School.subject.humanities.Philology;
import task3School.subject.humanities.Literature;
import task3School.subject.naturalSciences.NaturalSciences;

import java.util.ArrayList;
import java.util.List;

public class MainSchool {
    public static void main(String[] args) {

        StudentHumanities studentHumanities1 = new StudentHumanities("Komarov", new Humanities("Literature"));
        StudentHumanities studentHumanities2 = new StudentHumanities("Makarov", new Humanities("Literature"));
        StudentHumanities studentHumanities3 = new StudentHumanities("Mironov", new Humanities("Philology"));
        StudentHumanities studentHumanities4 = new StudentHumanities("Naumov", new Humanities("Philology"));
        StudentExactSciences studentExactSciences1 = new StudentExactSciences("Andreev", new ExactSciences("Mathematics"));
        StudentExactSciences studentExactSciences2 = new StudentExactSciences("Bohdanov", new ExactSciences("Mathematics"));
        StudentExactSciences studentExactSciences3 = new StudentExactSciences("Volkov", new ExactSciences("Physics"));
        StudentExactSciences studentExactSciences4 = new StudentExactSciences("Grekov", new ExactSciences("Physics"));
        StudentNaturalSciences studentNaturalSciences1 = new StudentNaturalSciences("Egorov", new NaturalSciences("Biology"));
        StudentNaturalSciences studentNaturalSciences2 = new StudentNaturalSciences("Ivanov", new NaturalSciences("Biology"));
        StudentNaturalSciences studentNaturalSciences3 = new StudentNaturalSciences("Klimov", new NaturalSciences("Chemistry"));
        StudentNaturalSciences studentNaturalSciences4 = new StudentNaturalSciences("Kozlov", new NaturalSciences("Chemistry"));

        List<Student> students = new ArrayList<>();
        students.add(studentHumanities1);
        students.add(studentHumanities2);
        students.add(studentHumanities3);
        students.add(studentHumanities4);
        students.add(studentExactSciences1);
        students.add(studentExactSciences2);
        students.add(studentExactSciences3);
        students.add(studentExactSciences4);
        students.add(studentNaturalSciences1);
        students.add(studentNaturalSciences2);
        students.add(studentNaturalSciences3);
        students.add(studentNaturalSciences4);

        System.out.println(students);

//        ClassExactSciences mathStudent1 = new ClassExactSciences<>(new Student("Andreev"), new Mathematics("Mathematics"));
//        ClassExactSciences mathStudent2 = new ClassExactSciences<>(new Student("Bohdanov"), new Mathematics("Mathematics"));
//        ClassExactSciences physicsStudent1 = new ClassExactSciences<>(new Student("Volkov"), new Physics("Physics"));
//        ClassExactSciences physicsStudent2 = new ClassExactSciences<>(new Student("Grekov"), new Physics("Physics"));
//        ClassNaturalSciences biologyStudent1 = new ClassNaturalSciences<>(new Student("Egorov"), new Biology("Biology"));
//        ClassNaturalSciences biologyStudent2 = new ClassNaturalSciences<>(new Student("Ivanov"), new Biology("Biology"));
//        ClassNaturalSciences chemistryStudent1 = new ClassNaturalSciences<>(new Student("Klimov"), new Chemistry("Chemistry"));
//        ClassNaturalSciences chemistryStudent2 = new ClassNaturalSciences<>(new Student("Kozlov"), new Chemistry("Chemistry"));
//        ClassHumanities literatureStudent1 = new ClassHumanities<>(new Student("Komarov"), new Literature("Literature"));
//        ClassHumanities literatureStudent2 = new ClassHumanities<>(new Student("Makarov"), new Literature("Literature"));
//        ClassHumanities philologyStudent1 = new ClassHumanities<>(new Student("Mironov"), new Philology("Philology"));
//        ClassHumanities philologyStudent2 = new ClassHumanities<>(new Student("Naumov"), new Philology("Philology"));
//
//        List<ClassHumanities> array = new ArrayList<>();
//        array.add(literatureStudent1);
//        array.add(literatureStudent2);
//        array.add(philologyStudent1);
//        array.add(philologyStudent2);
//
//        List<ClassNaturalSciences> array1 = new ArrayList<>();
//        array1.add(biologyStudent1);
//        array1.add(biologyStudent2);
//        array1.add(chemistryStudent1);
//        array1.add(chemistryStudent2);
//
//        List<ClassExactSciences> array2 = new ArrayList<>();
//        array2.add(mathStudent1);
//        array2.add(mathStudent2);
//        array2.add(physicsStudent1);
//        array2.add(physicsStudent2);
//
//
//        System.out.println(array);
//        System.out.println(array1);
//        System.out.println(array2);

    }
}

//Создайте иерархию учебных предметов (Subject -> Natural sciences/exact sciences/humanities ->
// Biology, Chemistry / Physics, Mathematics / Literature, Philology).
// Напишите класс Student, параметризируемый предметом.
// Создайте классы студентов по каждому из направлений (Natural sciences/exact sciences/humanities),
// укажите в наследуемом параметре конкретный тип направления