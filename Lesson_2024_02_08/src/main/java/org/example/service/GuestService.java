package org.example.service;

import org.example.dto.guest.Guest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
@Service
public class GuestService {
private final Map<Long, Guest> idToGuest;
private long count;

    public GuestService(List<Guest> guestList) {
        this.idToGuest = new HashMap<>();
        count=0;
    }

    public Guest createGuest(String name){
        Guest guest=new Guest(++count,name,1);
        idToGuest.put(guest.id(), guest);
        return guest;
    }

    public void addOrder(long id){
      Guest oldGuest = Optional.ofNullable(idToGuest.get(id)).orElseThrow();
      Guest guest=new Guest(id, oldGuest.name(), oldGuest.order()+1);
      idToGuest.put(id, guest);
    }

    public Guest get(long id){
        return Optional.ofNullable(idToGuest.get(id)).orElseThrow();
    }
}




//Создайте приложение для кафе, которое запоминает имя посетителя и
// время его первого заказа в день. Посетитель может делать заказы и
// получать случайную скидку в течение суток после первого заказа
// (для упрощения в течение 30 секунд). Через сутки система «забывает» посетителя. Используйте Session scope бин для хранения информации о посетителе и времени его первого заказа. Создайте контроллер для обработки заказов и выдачи скидок.


//Создайте приложение для кафе, которое запоминает имя посетителя и время его первого заказа в день. Посетитель может делать заказы и получать случайную скидку в течение суток после первого заказа (для упрощения в течение 30 секунд). Через сутки система «забывает» посетителя. Используйте Session scope бин для хранения информации о посетителе и времени его первого заказа. Создайте контроллер для обработки заказов и выдачи скидок.