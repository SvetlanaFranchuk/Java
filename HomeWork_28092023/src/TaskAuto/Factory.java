package TaskAuto;

public class Factory {
    public Auto makeTruck(int power, String brand, String model){
        TypeAuto typeAuto = TypeAuto.TRUCK;
        Auto auto = new Auto();
        auto.setTypeAuto(typeAuto);
        auto.power = power;
        auto.brand = brand;
        auto.setModel(model);
        return auto;
    }
    public Auto makeSportsCar(int power, String brand, String model){
        TypeAuto typeAuto = TypeAuto.SPORTS;
        Auto auto = new Auto();
        auto.setTypeAuto(typeAuto);
        auto.power = power;
        auto.brand = brand;
        auto.setModel(model);
        return auto;
    }
    public Auto makePassengerCar(int power, String brand, String model){
        TypeAuto typeAuto = TypeAuto.PASSENGER;
        Auto auto = new Auto();
        auto.setTypeAuto(typeAuto);
        auto.power = power;
        auto.brand = brand;
        auto.setModel(model);
        return auto;
    }

}
