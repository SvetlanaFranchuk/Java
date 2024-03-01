package org.example.hotelbookingapplication.controller;

import jakarta.validation.constraints.Min;
import org.example.hotelbookingapplication.dto.user.UserResponseDto;
import org.example.hotelbookingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {
    //TODO дописать, если задание будет расширяться
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable("id") @Min(0) long id) {
        return userService.getUser(id);
    }

}
