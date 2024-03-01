package org.example.hotelbookingapplication.mapper;

import jakarta.annotation.Nullable;
import org.example.hotelbookingapplication.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapplication.dto.booking.BookingFormData;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.user.User;
import org.example.hotelbookingapplication.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookingMapper {

public Booking toBooking(@Nullable Long id, LocalDate startDate, LocalDate endDate,
                         User user, Room room) {
    Booking booking = new Booking();
    booking.setId(id);
    booking.setStartDate(startDate);
    booking.setEndDate(endDate);
    booking.setStatusBooking(StatusBooking.NEW);
    booking.setBookDate(LocalDate.now());
    booking.setUser(user);
    booking.setRoom(room);
    return booking;
}

public BookingResponseDto toBookingResponseDto(Booking booking){
    return new BookingResponseDto(booking.getStartDate(),
            booking.getEndDate(), booking.getStatusBooking(),
            booking.getBookDate(), booking.getTypeByFood(),
            booking.getUser().getId(), booking.getRoom().getNumber());
}

public BookingCreateRequestDto toBookingCreateRequestDto(BookingFormData bookingForm){
    return new BookingCreateRequestDto(bookingForm.getStartDate(),
            bookingForm.getEndDate(), bookingForm.getStatusBooking(),
            LocalDate.now(), bookingForm.getTypeByFood(),
            bookingForm.getUserId(), bookingForm.getRoomId());
}

}
