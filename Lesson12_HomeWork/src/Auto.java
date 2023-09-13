public class Auto {
    //Напишите класс Автомобиль с минимум пятью полями. Переопределите метод
    // toString, чтобы он выводил полное описание автомобиля по его полям.
    private ModelAuto model;
    private double year;
    private double price;
    private TypeAuto type;
    private int power;

    public Auto() {
    }

    public Auto(ModelAuto model, double year, double price, TypeAuto type, int power) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.type = type;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model=" + model +
                ", year=" + year +
                ", price=" + price +
                ", type=" + type +
                ", power=" + power +
                '}';
    }
}
