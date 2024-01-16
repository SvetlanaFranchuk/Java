import customer.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.NotificationService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Customer customer1 = context.getBean("customer", Customer.class);
        System.out.println(customer1.toString());

        //просто решила попробовать задание значений двумя вариантами в xml и после получения из xml
        Customer customer2 = context.getBean("customerEmpty", Customer.class);
        customer2.setId(2);
        customer2.setName("Sarah");
        customer2.setDateOfLastNotification(LocalDate.of(2024,1,16));
        customer2.setPhone("+19158455617");
        customer2.setEmail("sarah-sweet@candy.com");
        System.out.println(customer2.toString());

        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
        notificationService.sendSpam(customer1);
        notificationService.sendSpam(customer2);

        context.close();
    }
}
