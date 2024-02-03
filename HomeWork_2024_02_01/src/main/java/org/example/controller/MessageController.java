package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final ObjectMapper mapper;

    @Autowired
    public MessageController(MessageService messageService, ObjectMapper mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @GetMapping(path="/messages", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMessages() {
        try {
            return mapper.writeValueAsString(messageService.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/messages")
    public String postMessages(@RequestBody String message){
        if (message == null || message.isEmpty()){
            return "show_error";
        }
        messageService.putMessage(message);
        return "show_accepted";
    }
}
//Создайте простое веб-приложение, которое принимает POST-запрос с текстом и
//добавляет этот текст в список. В ответ на POST запрос приложение отправляет
//представление с текстом «Ваше сообщение принято». По GET-запросу приложение
//возвращает список всех сообщений в виде JSON