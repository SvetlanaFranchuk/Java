package customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
    private long id;
    private String name;
    private LocalDate dateOfLastNotification;
    private String phone;
    private String email=null;

    public Customer() {
    }

    public Customer(long id, String name, LocalDate dateOfLastNotification, String phone, String email) {
        this.id = id;
        this.name = name;
        this.dateOfLastNotification = dateOfLastNotification;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfLastNotification() {
        return dateOfLastNotification;
    }

    public void setDateOfLastNotification(LocalDate dateOfLastNotification) {
        this.dateOfLastNotification = dateOfLastNotification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id + "L" +
                ", name='" + name + '\'' +
                ", dateOfLastNotification=" + DateTimeFormatter.ofPattern("yyyy-dd-MM").format(dateOfLastNotification) +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
