package service;

import customer.Customer;

public interface SmsNotificationService {
    void sendSpamToSMS(Customer customer);
}
