package org.example.hotelbookingapplication.repository;

import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.TypeByFood;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Set<Booking> findAllByUser(User user);
    List<Room> findAllByRoom();

    Booking findBookingByUserAndRoomAndStartDateAndTypeByFood(User user,
                                                              Room room,
                                                              LocalDate StartDate,
                                                              TypeByFood typeByFood);
}
