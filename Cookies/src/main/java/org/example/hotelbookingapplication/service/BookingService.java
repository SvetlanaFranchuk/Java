package org.example.hotelbookingapplication.service;

import org.example.hotelbookingapplication.dao.booking.BookingDao;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.dto.booking.RoomDto;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.mapper.BookingMapper;
import org.example.hotelbookingapplication.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
private final BookingRepository bookingRepository;
private final BookingMapper bookingMapper;
private final BookingDao bookingDao;

 @Autowired
 public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper,
                       BookingDao bookingDao) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.bookingDao = bookingDao;
    }

 public BookingResponseDto getBooking(long id){
     Booking booking = bookingRepository.getReferenceById(id);
     return bookingMapper.toBookingResponseDto(booking);
 }

 public List<Room> readAllAvailableRooms(LocalDate startDate, LocalDate endDate){
      return bookingDao.readAllAvailable(startDate,endDate);
 }
}
