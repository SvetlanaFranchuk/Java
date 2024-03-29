package org.example.controller;

import org.example.dto.User;
import org.example.dto.UserFormData;
import org.example.dto.UserSession;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    private final UserService userService;
    private final UserSession sessionControl;


    @Autowired
    public ViewController(UserService userService,
                          @Qualifier ("sessionControl") UserSession sessionControl) {
        this.userService = userService;
        this.sessionControl = sessionControl;
    }

    @GetMapping("/profile/{userId}")
    public String getProfileView(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("id", user.id());
        model.addAttribute("firstName", user.firstName());
        model.addAttribute("lastName", user.lastName());
        model.addAttribute(
                "age",
                user.birthDate() == null ? "" : Period.between(user.birthDate(), LocalDate.now()).getYears()
        );
        model.addAttribute("email", user.email() != null ? user.email() : "");
        model.addAttribute("status", user.status() == true ? "active":"not active");

        model.addAttribute("message", sessionControl.getWelcomeMessage());
        sessionControl.setNewUser(false);
        return "user_profile";
    }

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        model.addAttribute("userForm", new UserFormData());
        return "user_registration";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("userForm") UserFormData userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user_registration_error";
        }
        User newUser = userService.createUser(userForm.toUser());
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUser);
        sessionControl.setNewUser(true);
        model.addAttribute("message", sessionControl.getWelcomeMessage());
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/{userId}/edit")
    public String getEditProfileForm(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(user.firstName());
        userFormData.setLastName(user.lastName());
        userFormData.setBirthDate(user.birthDate());
        userFormData.setEmail(user.email());
        model.addAttribute("editForm", userFormData);
        model.addAttribute("userId", userId);
        sessionControl.setNewUser(false);
        model.addAttribute("message", sessionControl.getWelcomeMessage());
        return "user_profile_edit";
    }

    @PutMapping("/profile/{userId}/edit")
    public String editProfile(
            @PathVariable("userId") long userId,
            @ModelAttribute("editForm") UserFormData userForm,
            BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            return "user_profile_edit_error";
        }
        User updatedUserDto = userService.updateUser(userId, userForm.toUser());
        model.addAttribute("updatedUser", updatedUserDto);
        return "user_profile_edit_success";
    }


    @GetMapping("/profile/{id}/delete")
    public String getDeleteForm(@PathVariable("id") long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("deletedUser", user);
        return "user_delete";
    }

    @DeleteMapping("/profile/{id}/delete")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "user_delete_success";
    }

    @GetMapping("/editStatus")
    public String getEditStatusForm(Model model) {
        List<User> users = userService.getUsers("");
        model.addAttribute("users", users);
        return "user_status_edit";
    }

    @PatchMapping("/editStatus")
    public String updateUserStatus(@RequestParam("id") long id,
                                   @RequestParam("status") boolean status,
                                   Model model) {
        model.addAttribute("user", userService.setStatus(status, id));
        return "redirect:/view/profile/" + id;
    }

}
//В проекте SpringMvcHtmlFormProblemExample, который был дополнен фильтром,
// реализуйте представление для пользователя, содержащее форму с кнопкой Delete и
// выполняющую http-метод DELETE. По нажатии на кнопку из хранилища данных должен
// удаляться пользователь с указанным в URL идентификатором.