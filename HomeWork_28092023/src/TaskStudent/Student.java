package TaskStudent;
//Создайте класс Студент, имеющий поля имя, фамилия и номер группы.
//1 Напишите минимум 2 конструктора для класса Студент.
//2 Реализуйте геттеры и сеттеры для класса Студент. В сеттере сделайте проверку,
// что номер группы положительный. В противном случае бросьте исключение throw new
// RuntimeException(“Номер группы должен быть положительным”);
//3 Создайте метод «перейти в следующую группу». При вызове метода студент переводится
// в следующую по номеру группу (чтобы не сдавать экзамены  ).
public class Student {
    private String firstName;
    private String lastName;
    private int group;

    public Student(){}

    public Student(String firstName, String lastName, int group){
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        if (group<0){
            throw new RuntimeException("Номер группы должен быть положительный");
        }
        this.group = group;
    }

    public void moveNextGroup(){
        this.group ++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                '}';
    }

    public Student(Student original){
        this(original.firstName, original.lastName, original.group);
    }
}
