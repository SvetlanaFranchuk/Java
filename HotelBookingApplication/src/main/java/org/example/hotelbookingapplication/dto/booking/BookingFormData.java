package org.example.hotelbookingapplication.dto.booking;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.booking.TypeByFood;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookingFormData {
    @Future(message = "Date of start must be in the future")
    private LocalDate startDate;

    @Future(message = "Date of end must be in the future")
    private LocalDate endDate;

    @NotNull
    private StatusBooking statusBooking;

    @NotNull
    private LocalDate bookDate;

    @NotNull
    private TypeByFood typeByFood;

    @NotNull @Min(0)
    private Long userId;

    @NotNull @Min(0)
    private int roomId;
}
