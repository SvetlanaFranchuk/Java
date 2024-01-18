package cars;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GasCar car1= context.getBean("gasCar", GasCar.class);
        car1.getEngine().useEngine();
        ElectricCar car2= context.getBean("electricCar", ElectricCar.class);
        car2.getEngine().useEngine();
        context.close();
    }
}
