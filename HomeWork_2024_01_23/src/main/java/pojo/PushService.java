package pojo;

import interf.NotificationService;
import org.springframework.stereotype.Component;
import utils.Util;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PushService implements NotificationService {

    private final Schedule schedule;

    public PushService(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void sendMessage() {
        List<Task> urgentList = Util.getUrgentTask(schedule);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Push message: you have next urgent task:");
        urgentList.forEach(t-> System.out.println(t.getTitle() + ". Start " + t.getStartDateTime().format(formatter)));
    }


}
