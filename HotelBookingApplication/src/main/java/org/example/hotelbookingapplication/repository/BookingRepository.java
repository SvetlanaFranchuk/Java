package org.example.hotelbookingapplication.repository;

import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByUser (User user);
    List<Booking> findAllByRoom(Room room);

    List<Booking> findAllByStartDateBetween(LocalDate startDate, LocalDate twoDate);

    List<Booking> findAllByStatusBooking(StatusBooking statusBooking);

}
