package service;

import customer.Customer;

public interface EmailNotificationService {
    void sendSpamToEmail(Customer customer);
}
