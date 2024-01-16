package service;

import customer.Customer;

public class EmailNotificationServiceImpl implements EmailNotificationService{
    @Override
    public void sendSpamToEmail(Customer customer) {
        System.out.println("Send spam to " + customer.getName() + " to email: " + customer.getEmail());
    }
}
