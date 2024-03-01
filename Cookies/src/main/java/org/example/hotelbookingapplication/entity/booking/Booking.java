package org.example.hotelbookingapplication.entity.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.user.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_booking")
    private StatusBooking statusBooking;

    @Column(name = "book_date")
    private LocalDate bookDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_by_food")
    private TypeByFood typeByFood;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
