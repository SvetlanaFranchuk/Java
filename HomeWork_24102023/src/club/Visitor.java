package club;

import java.util.concurrent.ThreadLocalRandom;

public class Visitor {
    private int age;

    public Visitor() {
        this.age = ThreadLocalRandom.current().nextInt(12,70);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "age=" + age +
                '}';
    }
}
