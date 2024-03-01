package org.example.hotelbookingapplication.dto.user;

import jakarta.validation.constraints.*;
import org.example.hotelbookingapplication.entity.user.Role;

import java.time.LocalDate;

public record UserResponseDto(
    //TODO - не используется в рамках данного задания, доработать при расширении ТЗ
    @Min(0) Long id,
    @NotNull @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols")
    String firstName,

    @NotNull @Size(min = 1, max = 100, message = "Last name length could be from 1 to 100 symbols")
    String lastName,

    @Past(message = "Date of birth must be in the past")
    LocalDate birthDate,

    @NotBlank @Email(message = "Email not correct")
    String email,

    @NotBlank @NotNull @Size(min = 1, max = 15, message = "Password length could be from 1 to 15 symbols")
    String password,
    @NotNull Role role,
    boolean isBlocked
){}
