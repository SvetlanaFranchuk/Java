package org.example.hotelbookingapplication.dto.booking;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.booking.TypeByFood;

import java.time.LocalDate;

public record BookingCreateRequestDto (
    @Future(message = "Date of start must be in the future")
    LocalDate startDate,

    @Future(message = "Date of end must be in the future")
    LocalDate endDate,

    @NotNull
    StatusBooking statusBooking,

    @NotNull
    LocalDate bookDate,

    @NotNull
    TypeByFood typeByFood
){}
