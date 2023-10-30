package task3School.subject;

public abstract class Subject {
    public String name;

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
