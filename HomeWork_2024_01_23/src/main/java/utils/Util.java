package utils;

import pojo.PriorityType;
import pojo.Schedule;
import pojo.Task;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public Util() {
    }

    public static List<Task> getUrgentTask(Schedule schedule){
        return schedule.getTasks().stream()
                .filter(t->t.getPriority()== PriorityType.HIGH).toList();
    }
}
