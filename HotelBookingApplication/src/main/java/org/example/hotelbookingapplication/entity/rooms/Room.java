package org.example.hotelbookingapplication.entity.rooms;

import jakarta.persistence.*;
import lombok.*;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.TypeByFood;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"bookings"})
@EqualsAndHashCode(exclude = {"bookings"})
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_by_count_person")
    private TypeByCountPerson typeByCountPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_by_size")
    private TypeBySize typeBySize;

    @Column(name = "floor")
    private int floor;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    public void addBooking(Booking booking){
        bookings.add(booking);
        booking.setRoom(this);
    }

    public void removeBooking(Booking booking){
        bookings.remove(booking);
        booking.setRoom(null);
    }
}
