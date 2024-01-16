package service;

import customer.Customer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotificationService {

    private SmsNotificationService smsNotificationService;
    private EmailNotificationService emailNotificationService;

    public NotificationService(SmsNotificationService smsNotificationService, EmailNotificationService emailNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
    }

    public void sendSpam(Customer customer) {
        LocalDate currentDate = LocalDate.now();
        if (ChronoUnit.DAYS.between(currentDate, customer.getDateOfLastNotification()) >= 30){
            if (customer.getEmail() != null) emailNotificationService.sendSpamToEmail(customer);
            smsNotificationService.sendSpamToSMS(customer);
            }
    }
}
