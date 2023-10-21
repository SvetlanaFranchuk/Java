package fullName;

public class FullName implements Comparable {
    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) throw new IllegalArgumentException("bad type of object");
        FullName fullName = (FullName) o;
        return firstName.compareTo(fullName.firstName);

    }

}

// 1 уровень сложности: 1 Создайте класс fullName.FullName полного имени человека (firstName, lastName).
// Создайте TreeSet с экземплярами этого класса. При создании TreeSet передайте в него компаратор,
// который сравнивает экземпляры по полю firstName. Выведите множество в консоль.

//2 Создайте коллекцию (List или Set), добавьте несколько элементов.
// Организовать цикл while по коллекции с помощью итератора. Организовать цикл for (не путать с foreach!)
// по коллекции с помощью итератора.
//3 Создайте итератор по массиву целых чисел, который будет выводить элементы в порядке их убывания.
// Исходный массив не должен при этом измениться.