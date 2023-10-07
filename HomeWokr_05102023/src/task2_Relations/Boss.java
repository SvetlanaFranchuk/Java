package task2_Relations;

public class Boss{
 //агрегация - объект класса Босс содержит ссылку на класс Сотрудник
    private Emploee emploee;
    private Position position;

    public Boss(Emploee emploee) {
        this.emploee = emploee;
        this.position = Position.MANAGER;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "boss: " + emploee.getLastName() + " " + emploee.getFirstName() +
                ", position=" + position +
                '}';
    }
}
