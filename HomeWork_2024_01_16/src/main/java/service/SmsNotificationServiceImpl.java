package service;

import customer.Customer;

public class SmsNotificationServiceImpl implements SmsNotificationService{
    @Override
    public void sendSpamToSMS(Customer customer) {
        System.out.println("Send spam to " + customer.getName() + " in SMS, phone: " + customer.getPhone());
    }
}
