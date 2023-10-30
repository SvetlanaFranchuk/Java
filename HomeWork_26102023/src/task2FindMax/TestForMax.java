package task2FindMax;

public class TestForMax implements Comparable<TestForMax> {
    private String name;
    private int age;

    public TestForMax(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(TestForMax o) {
        if (name.compareTo(o.name)>0)  return 1;
        if (name.compareTo(o.name)<0)  return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "TestForMax{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
