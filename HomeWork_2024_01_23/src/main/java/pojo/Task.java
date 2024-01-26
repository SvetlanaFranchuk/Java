package pojo;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public final class Task {
    @Value("${task.default.title}")
    private String title;

    @Value("${task.default.description}")
    private String description;

    @Value("${task.default.priority}")
    private PriorityType priority;


    private LocalDateTime startDateTime;

    public Task() {
        this.startDateTime =  LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0));;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Task) obj;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.priority, that.priority) &&
                Objects.equals(this.startDateTime, that.startDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, priority, startDateTime);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return  "Title      : " + title + ", \n" +
                "Description: " + description + ", \n" +
                "Priority   : " + priority + ", \n" +
                "Start      : " + startDateTime.format(formatter) + "\n";
    }

}
