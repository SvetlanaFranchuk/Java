package org.example.hotelbookingapplication.mapper;

import org.example.hotelbookingapplication.dto.user.UserCreateRequestDto;
import org.example.hotelbookingapplication.dto.user.UserFormData;
import org.example.hotelbookingapplication.dto.user.UserResponseDto;
import org.example.hotelbookingapplication.entity.user.Role;
import org.example.hotelbookingapplication.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserCreateRequestDto requestDto){
        return User.builder()
                .firstName(requestDto.firstName())
                .lastName(requestDto.lastName())
                .birthDate(requestDto.birthDate())
                .email(requestDto.email())
                .password(requestDto.password())
                .role(requestDto.role())
                .isBlocked(requestDto.isBlocked())
        .build();
    }

    public UserResponseDto toUserResponseDto(User user){
        return new UserResponseDto(user.getId(), user.getFirstName(),
                user.getLastName(), user.getBirthDate(), user.getEmail(),
                user.getPassword(), user.getRole(), user.isBlocked());
    }

    public UserCreateRequestDto toUserCreateRequestDto(UserFormData userForm){
        return new UserCreateRequestDto(userForm.getFirstName(), userForm.getLastName(),
                userForm.getBirthDate(), userForm.getEmail(),
                userForm.getPassword(), Role.GUEST, false);
    }
}
