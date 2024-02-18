import fabrica.Plant;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Plant p1 = context.getBean("plant", Plant.class);
        Plant p2 = context.getBean("plant", Plant.class);

    }
}
//Создайте класс Plant с фабричным методом produceNewPlant. Создайте бин Plant.
//Проверьте, позволяет ли использование фабричного метода получать новые экземпляры
// бинов, если не указан scope singleton.
