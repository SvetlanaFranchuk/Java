package org.example.hotelbookingapplication.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.example.hotelbookingapplication.entity.user.Role;

import java.time.LocalDate;

public record UserCreateRequestDto (
    @NotNull @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols")
    String firstName,

    @NotNull @Size(min = 1, max = 100, message = "Last name length could be from 1 to 100 symbols")
    String lastName,

    @Past(message = "Date of birth must be in the past")
    LocalDate birthDate,

    @Email(message = "Email not correct")
    String email,

    @NotNull @Size(min = 1, max = 15, message = "Password length could be from 1 to 15 symbols")
    String password,

    @NotNull Role role,
    boolean isBlocked
){}
