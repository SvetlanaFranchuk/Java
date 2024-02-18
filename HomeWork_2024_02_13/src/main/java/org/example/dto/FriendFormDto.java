package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public final class FriendFormDto {
    @NotBlank
    @Size(min=2, max=50, message="The first name length must be from 1 to 50 characters")
    private String firstName;

    @NotBlank
    @Size(min=2, max=50, message="The last name length must be from 1 to 50 characters")
    private String lastName;

    @PastOrPresent(message = "Date of birth must be in the past")
    @NotNull(message = "Date can`t be empty")
    private LocalDate birthday;

    public FriendFormDto() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendFormDto friendDto = (FriendFormDto) o;
        return Objects.equals(firstName, friendDto.firstName) && Objects.equals(lastName, friendDto.lastName) && Objects.equals(birthday, friendDto.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }
}
