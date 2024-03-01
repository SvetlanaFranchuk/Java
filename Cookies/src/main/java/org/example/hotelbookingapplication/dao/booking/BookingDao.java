package org.example.hotelbookingapplication.dao.booking;

import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.rooms.TypeByCountPerson;
import org.example.hotelbookingapplication.entity.rooms.TypeBySize;

import java.time.LocalDate;
import java.util.List;

public interface BookingDao {
    Booking create(Booking booking);
    Booking read(long id);
    List<Booking> readAll();
    Booking update(Booking booking, long id);
    void delete(long id);
    List<Room> readAllAvailable(LocalDate startDate, LocalDate endDate);
    List<Room> readAllAvailableWithFilter(TypeByCountPerson typeByCountPerson, TypeBySize typeBySize,
                                          LocalDate startDate, LocalDate endDate);


}
