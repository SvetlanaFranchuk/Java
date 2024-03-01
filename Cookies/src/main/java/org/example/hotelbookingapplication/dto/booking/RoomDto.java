package org.example.hotelbookingapplication.dto.booking;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public record RoomDto(
        @Min(0) Integer id,
        @Positive double price
) {
}
