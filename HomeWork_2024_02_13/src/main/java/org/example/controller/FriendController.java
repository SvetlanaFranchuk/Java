package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.FriendFormDto;
import org.example.pojo.Friend;
import org.example.servise.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/friends")
public class FriendController {

    private FriendsService friendsService;

    @Autowired
    public FriendController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping("/newRecord")
    public String getFormForNewRecord(Model model) {
        model.addAttribute("friend", new FriendFormDto());
        return "friend_newRecord";
    }

    @PostMapping("/newRecord")
    public String addNewRecord(@ModelAttribute("friend")
                               @Valid FriendFormDto newForm,
                               BindingResult result, Model model) {
        if (result.hasErrors()) return "friend_newRecord";
        Friend friend = new Friend(newForm.getFirstName(),
                newForm.getLastName(), newForm.getBirthday());
        friendsService.addNewRecord(friend);
        model.addAttribute("friend", friend);
        return "add_newRecord_successfull";
    }

    @GetMapping("/all")
    @ResponseBody
    public String getFriends() {
        return friendsService.getFriends().toString();
    }

    @GetMapping("/today")
    @ResponseBody
    public String getTodayBirthdayFriend() {
        return friendsService.getTodayBirthdayFriend().toString();
    }

    @GetMapping("/searchByDate")
    public String getFormSearchByDate(Model model) {
        LocalDate date = LocalDate.now();
        model.addAttribute("birthdate", date);
        return "findByDate";
    }

    @PostMapping("/searchByDate")
    @ResponseBody
    public String searchByDate(@ModelAttribute("birthday") LocalDate birthday,
                               Model model) {
        model.addAttribute("birthday", birthday);
        List<Friend> friends = friendsService.getFriendsByDate(birthday);
        if (friends.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No one has a birthday on " + birthday);
        return friends.toString();
    }

    @GetMapping("/searchByName")
    public String getFormSearchByName(Model model) {
        model.addAttribute("friends", friendsService.getFriends());
        return "findByName";
    }

    @PostMapping("/searchByName")
    @ResponseBody
    public String searchByName(@ModelAttribute("firstName") String firstName,
                               @ModelAttribute("lastName") String lastName) {
        if (friendsService.isAbsentFriend(firstName, lastName))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Information about " + firstName + " " + lastName + " absent");
        return "Birthday " + firstName + " " +
                lastName + ": " + friendsService.getDate(firstName, lastName);
    }


}