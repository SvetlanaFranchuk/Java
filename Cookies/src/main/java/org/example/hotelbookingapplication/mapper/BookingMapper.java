package org.example.hotelbookingapplication.mapper;

import org.example.hotelbookingapplication.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapplication.dto.booking.BookingFormData;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookingMapper {

public Booking toBooking(BookingCreateRequestDto requestDto) {
    return new Booking(null, requestDto.startDate(),
            requestDto.endDate(), requestDto.statusBooking(),
            requestDto.bookDate(), requestDto.typeByFood(), null, null);
}

public BookingResponseDto toBookingResponseDto(Booking booking){
    return new BookingResponseDto(booking.getStartDate(),
            booking.getEndDate(), booking.getStatusBooking(),
            booking.getBookDate(), booking.getTypeByFood());
}

public BookingCreateRequestDto toBookingCreateRequestDto(BookingFormData bookingForm){
    return new BookingCreateRequestDto(bookingForm.getStartDate(),
            bookingForm.getEndDate(), bookingForm.getStatusBooking(),
            LocalDate.now(), bookingForm.getTypeByFood());
}

}
