package org.example.controller;

import org.example.dto.congratulate.CongratulationFormDto;
import org.example.dto.congratulate.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CongratulationController {
    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("congDto", new CongratulationFormDto("", Holiday.INDEPENDECE_DAY));
        List<Holiday> holidayList = Arrays.stream(Holiday.values()).toList();
        model.addAttribute("option", holidayList);
    return "congratulate_form";
    }

    @PostMapping("/form")
    public String createCongratulation(@ModelAttribute CongratulationFormDto dto, Model model) {
        model.addAttribute("congText", String.format(dto.holiday().getCongratulation(), dto.name()));
    return "congratulation";
    }
}
//Создайте приложение, которое предоставляет форму для ввода
// имени человека и выбора праздника (например, День Рождения,
// Новый Год, 8 Марта), и возвращает поздравление в виде
// «Дорогой(ая) ИМЯ – ПОЗДРАВЛЕНИЕ (выбранный праздник)».
// Используйте статический словарь для генерации поздравлений.