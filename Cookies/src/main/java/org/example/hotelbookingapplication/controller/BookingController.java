package org.example.hotelbookingapplication.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Min;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.dto.booking.RequestCount;
import org.example.hotelbookingapplication.dto.booking.RoomDto;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping(path="/booking")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public BookingResponseDto getOrder(@PathVariable("id") @Min(0) long id) {
        return bookingService.getBooking(id);
    }

    @GetMapping("/allAvailable/{startDate}/{endDate}")
    public List<Room> getAllAvailableRoom(@PathVariable("startDate")LocalDate startDate,
                                          @PathVariable("endDate")LocalDate endDate) {
        return bookingService.readAllAvailableRooms(startDate,endDate);
    }

    @GetMapping("/count")
    public RequestCount getCounter(HttpSession session, HttpServletResponse response){
        Integer count = (Integer) session.getAttribute("requestCount");
        count = count==null ? 1: count+1;
        session.setAttribute("requestCount", count);
        Cookie cookie = new Cookie("cook", "first_cook");
        cookie.setPath("/");
        response.addCookie(cookie);
        return new RequestCount(count, session.getId());
    }
}
