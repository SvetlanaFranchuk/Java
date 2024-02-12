package org.example.dto;

import java.time.LocalDate;
import java.util.Objects;

public final class UserFormData { // TODO сделать валидацию значений в будущем https://www.wimdeblauwe.com/blog/2021/05/23/form-handling-with-thymeleaf/
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private boolean status;

    public UserFormData() { }

    public User toUser() {
        return new User(null, firstName, lastName, birthDate, email, status);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFormData that = (UserFormData) o;
        return status == that.status &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, email, status);
    }

    @Override
    public String toString() {
        return "UserFormData[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "birthDate=" + birthDate + ", " +
                "email=" + email + ", " +
                "status=" + status + ']';
    }

}
