package conf;

import interf.NotificationService;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import pojo.Connector;
import pojo.EmailService;
import pojo.Schedule;
import pojo.Task;

@Configuration
@ComponentScan("pojo")
@PropertySource("classpath:application.properties")
public class Config {

    @Bean(name="task")
    @Scope("prototype")
    public Task task(){
        return new Task();
    }
    @Bean
    @DependsOn("task")
    public Schedule schedule(@Value("${task.list.size}") int size) {
        return new Schedule(size, task());
    }

    @Bean
    @Lazy
    public Connector connector(){
        return new Connector();
    }
}
