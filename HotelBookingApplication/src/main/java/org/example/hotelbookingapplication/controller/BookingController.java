package org.example.hotelbookingapplication.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.hotelbookingapplication.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.dto.booking.RoomDto;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.rooms.TypeByCountPerson;
import org.example.hotelbookingapplication.entity.rooms.TypeBySize;
import org.example.hotelbookingapplication.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping(path="booking")
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

    @GetMapping("/allAvailable")
    public List<Room> getAllAvailableRoom(@RequestParam LocalDate startDate,
                                          @RequestParam LocalDate endDate) {
        return bookingService.readAllAvailableRooms(startDate,endDate);
    }

    @GetMapping("/allAvailableTypeByCountPerson")
    public List<Room> getAllAvailableRoomWithTypeByCountPerson(@RequestParam LocalDate startDate,
                                                               @RequestParam LocalDate endDate,
                                                               @RequestParam TypeByCountPerson typeByCountPerson) {
        return bookingService.readAllAvailableRoomsWithTypeByCountPerson(startDate,endDate,typeByCountPerson);
    }

    @GetMapping("/allAvailableTypeBySize")
    public List<Room> getAllAvailableRoomWithTypeBySize(@RequestParam LocalDate startDate,
                                                        @RequestParam LocalDate endDate,
                                                        @RequestParam TypeBySize typeBySize) {
        return bookingService.readAllAvailableRoomsWithTypeBySize(startDate,endDate,typeBySize);
    }

    @PostMapping()
    public BookingResponseDto createBooking(@RequestBody @Valid BookingCreateRequestDto requestDto){
        return bookingService.createBooking(requestDto, null );
    }

    @DeleteMapping("/{id}")
    public void  cancelBooking(@PathVariable("id") @Min(0) long id) {
        bookingService.cancelBooking(id);
    }

//    @GetMapping("/allBookingByStatus/{status}") //TODO доработать при расширении задачи
//    public List<BookingResponseDto> getAllOrdersByStatus(@PathVariable("status")StatusBooking statusBooking) {
//        return bookingService.getAllBookingByStatus(statusBooking);
//    }
//
//
//    @GetMapping("/allBookingByUser/{userId}") //TODO доработать при расширении задачи
//    public List<BookingResponseDto> getAllOrdersByUser(@PathVariable("userId") Long userId) {
//        return bookingService.getAllBookingByUser(userId);
//    }
//
//    @GetMapping("/allBookingByRoom/{roomId}") //TODO доработать при расширении задачи
//    public List<BookingResponseDto> getAllOrdersByRoom(@PathVariable("roomId") int roomId) {
//        return bookingService.getAllBookingByRoom(roomId);
//    }

}

