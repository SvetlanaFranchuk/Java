package org.example.controller;

import org.example.dto.guest.Guest;
import org.example.dto.guest.GuestRegistrationForm;
import org.example.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/create")
    public String createGuest(Model model){
        model.addAttribute("guestDto", new GuestRegistrationForm(0,""));
        return "guest_registration";
    }

    @PostMapping("/create")
    public String postGuest(@ModelAttribute("guestDto") GuestRegistrationForm guest,
                            Model model){
        if (guest.id() > 0){
            Guest exited =guestService.get(guest.id());
            guestService.addOrder(exited.id());
            model.addAttribute("name", exited.name());
            model.addAttribute("disc", exited.order());
            return "guest_welcome";
        }
        Guest newGuest=guestService.createGuest(guest.name());
        model.addAttribute("guestDTO", newGuest);
        return "guest_create";
    }


}
