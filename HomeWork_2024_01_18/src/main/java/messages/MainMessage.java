package messages;

import messages.generator.EmailSender;
import messages.generator.SmsSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainMessage {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (int i = 0; i < 5; i++) {

            EmailSender emailSender = context.getBean("emailSender", EmailSender.class);
            emailSender.sendMessage();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            SmsSender smsSender = context.getBean("smsSender", SmsSender.class);
            smsSender.sendMessage();
        }


        context.close();
    }
}
