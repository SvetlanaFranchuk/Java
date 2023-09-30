package TaskStudent;

public class MainStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Иван","Иванов", 1);
        Student student2 = new Student("Петр","Петров", 1);
        Student student3 = new Student("Сидор","Сидоров", 1);

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        student1.moveNextGroup();
        System.out.println(student1);

        Student student4 = new Student(student1);
        System.out.println(student1==student4);
        student4.setFirstName("Василий");

        System.out.println(student1.toString());
        System.out.println(student4.toString());
    }
}
