package org.example.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecondController {

    @GetMapping(path="/second",produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String showSecond(@RequestParam(name="name") String name){
        return "user " + name + " перенаправлен";
    }
}
