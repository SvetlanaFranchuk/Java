package org.example.hotelbookingapplication.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelbookingapplication.entity.user.Role;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
public final class UserFormData {
    private  @NotNull @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols") String firstName;
    private  @NotNull @Size(min = 1, max = 100, message = "Last name length could be from 1 to 100 symbols") String lastName;
    private  @Past(message = "Date of birth must be in the past") LocalDate birthDate;
    private  @Email(message = "Email not correct") String email;
    private  @NotNull @Size(min = 1, max = 15, message = "Password length could be from 1 to 15 symbols") String password;
    private  @NotNull Role role;
    private  boolean isBlocked;


}
