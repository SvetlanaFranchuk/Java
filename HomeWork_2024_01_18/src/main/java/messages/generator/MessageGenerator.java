package messages.generator;

import messages.interfaces.Sender;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Scope("prototype")
public class MessageGenerator {

    private static int counter = 0;
    private int idMessage;

    public MessageGenerator() {
        this.idMessage = counter++;
        //Юрий, подскажите пожалуйста - почему прибавление нумерации идет по 2, а не по одному
    }

    public int getIdMessage() {
        return idMessage;
    }

    public String generateMessage() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        return "Generated message at " + timestamp + " ID номер: " + idMessage;
    }

}
