package messages.generator;

import messages.interfaces.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class EmailSender implements Sender {

   @Autowired
    private MessageGenerator messageGenerator;

    public EmailSender(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void sendMessage() {
        String message = messageGenerator.generateMessage();
        System.out.println("Sending email: " + message);
    }
}
