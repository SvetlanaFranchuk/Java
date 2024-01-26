import conf.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Connector;
import pojo.EmailService;
import pojo.Schedule;
import pojo.Task;
import utils.Util;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Schedule schedule = context.getBean(Schedule.class);
        System.out.println("Start connecting to server");
        System.out.println();

        System.out.println("To-do list for a currently week");
        System.out.println(schedule);
        schedule.sendMessages();
        System.out.println();
        Connector connector = context.getBean(Connector.class);

        context.close();
    }
}
