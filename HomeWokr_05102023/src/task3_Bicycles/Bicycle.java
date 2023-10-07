package task3_Bicycles;

public class Bicycle {
    //Напишите класс Велосипед  с минимум пятью полями.
    // В программе создайте 3 разных велосипеда (например, шоссейный, горный, детский) и выведите каждый из них в консоль.
    //Создайте массив из этих велосипедов. С помощью Arrays.toString() превратите массив в строку и выведите в консоль. Запустите программу.
    //Вернитесь в объявление класса велосипед. Переопределите метод toString, чтобы он выводил полное описание велосипеда по его полям.
    //Перейдите в код метода Arrays.toString() и посмотрите на его реализацию. В какой момент автомобиль становится строкой внутри этого метода?

    private TypeBicycle typeBicycle;
    private int countOfWheel;
    private Boolean isElectro;
    private double price;
    private String model;

    public Bicycle(TypeBicycle typeBicycle, int countOfWheel, Boolean isElectro, double price, String model) {
        this.typeBicycle = typeBicycle;
        this.countOfWheel = countOfWheel;
        this.isElectro = isElectro;
        this.price = price;
        this.model = model;
    }

    public TypeBicycle getTypeBicycle() {
        return typeBicycle;
    }

    public int getCountOfWheel() {
        return countOfWheel;
    }

    public Boolean getElectro() {
        return isElectro;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "typeBicycle=" + typeBicycle +
                ", countOfWheel=" + countOfWheel +
                ", isElectro=" + isElectro +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}
