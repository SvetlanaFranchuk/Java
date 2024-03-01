package org.example.hotelbookingapplication.dto.booking;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.booking.TypeByFood;

import java.time.LocalDate;

public record BookingResponseDto(
        @Future(message = "Date of start must be in the future")
        LocalDate startDate,

        @Future(message = "Date of end must be in the future")
        LocalDate endDate,

        @NotNull
        StatusBooking statusBooking,

        @NotNull
        LocalDate bookDate,

        @NotNull
        TypeByFood typeByFood,

        @NotNull @Min(0) Long userId,
        @NotNull @Min(0) int roomId
) {
}
