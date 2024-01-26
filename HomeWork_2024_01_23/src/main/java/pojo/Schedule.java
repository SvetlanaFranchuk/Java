package pojo;

import interf.NotificationService;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Schedule {

    private int size;
    private final List<Task> tasks;

    @Autowired
   // @Qualifier("emailService")
    @Qualifier("pushService")
    private NotificationService service;

    public Schedule(int size, Task defaultTask) {
        this.size = size;
        this.tasks = generateSchedule(defaultTask);
    }

    public void sendMessages(){
        service.sendMessage();
    }

    private List<Task> generateSchedule(Task defaultTask){
        List<Task> result = new ArrayList<>();
        result.add(defaultTask);
        for (int i = 1; i < this.size; i++) {
            Task newTask = new Task();
            newTask.setTitle("Task " + (i+1));
            newTask.setDescription("Do something for task " + (i+1));
            PriorityType priorityType= switch (ThreadLocalRandom.current().nextInt(0,3)){
                case 0 -> PriorityType.HIGH;
                case 1 -> PriorityType.NORMAL;
                case 2 -> PriorityType.LOW;
                default -> null;
            };
            newTask.setPriority(priorityType);
            newTask.setStartDateTime(LocalDateTime.of(LocalDate.now()
                    .plusDays(ThreadLocalRandom.current().nextInt(0,5)),
                    LocalTime.of(9 + ThreadLocalRandom.current().nextInt(0,7), 0)));
            result.add(newTask);
        }
        return result;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i+1));
            System.out.println(tasks.get(i));
        }
        return "";
    }
}
