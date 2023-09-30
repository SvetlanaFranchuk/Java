package TaskAuto;
//Создайте объект этого класса в программе и попробуйте установить значения для полей.
// Какие поля возможно установить? - ПУБЛИЧНЫЕ И БЕЗ МОДИФИКАТОРА
// Для приватных полей напишите геттеры и сеттеры.
public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto();
        auto1.brand = "BMW";
        auto1.power = 140;

        Factory autoFactory = new Factory();
        Auto auto2 = autoFactory.makeTruck(1200, "Hyundai", "Эвакуатор");
        Auto auto3 = autoFactory.makeSportsCar(800, "Bugatti", "Chiron Super Sport 300+");
        Auto auto4 = autoFactory.makePassengerCar(120, "Audi", "A3");

        printCharacter(auto1);
        printCharacter(auto2);
        printCharacter(auto3);
        printCharacter(auto4);

    }

    static void printCharacter(Auto auto){
        System.out.println("Автомобиль: бренд " + auto.brand + "; тип " + auto.getTypeAuto() + "; модель " + auto.getModel() + "; мощность " + auto.power + " л.с.");
    }

}