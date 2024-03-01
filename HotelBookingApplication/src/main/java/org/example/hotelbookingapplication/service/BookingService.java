package org.example.hotelbookingapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.hotelbookingapplication.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapplication.dto.booking.BookingResponseDto;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.rooms.TypeByCountPerson;
import org.example.hotelbookingapplication.entity.rooms.TypeBySize;
import org.example.hotelbookingapplication.entity.user.User;
import org.example.hotelbookingapplication.mapper.BookingMapper;
import org.example.hotelbookingapplication.repository.BookingRepository;
import org.example.hotelbookingapplication.repository.RoomRepository;
import org.example.hotelbookingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
private final BookingRepository bookingRepository;
private final UserRepository userRepository;
private final RoomRepository roomRepository;
private final BookingMapper bookingMapper;
 @Autowired
 public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper,
                       UserRepository userRepository,
                       RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

 public BookingResponseDto getBooking(long id){
     Booking booking = bookingRepository.getReferenceById(id);
     return bookingMapper.toBookingResponseDto(booking);
 }

 public List<Room> readAllAvailableRooms(LocalDate startDate, LocalDate endDate){
        return roomRepository.findAvailableRooms(startDate, endDate);
 }

    public List<Room> readAllAvailableRoomsWithTypeByCountPerson(LocalDate startDate, LocalDate endDate,
                                                              TypeByCountPerson typeByCountPerson){
        return readAllAvailableRooms(startDate, endDate).stream()
                .filter(r->r.getTypeByCountPerson().equals(typeByCountPerson)).toList();
 }

 public List<Room> readAllAvailableRoomsWithTypeBySize(LocalDate startDate, LocalDate endDate,
                                                       TypeBySize typeBySize){
        return readAllAvailableRooms(startDate, endDate).stream()
                .filter(r->r.getTypeBySize().equals(typeBySize)).toList();
 }

 @Transactional
    public BookingResponseDto createBooking(BookingCreateRequestDto newBooking, Long id){
     User user = userRepository.findById(newBooking.userId())
             .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id=" + newBooking.userId()));
     Room room = roomRepository.findById(newBooking.roomId())
             .orElseThrow(() -> new EntityNotFoundException("Cannot find room with id=" + newBooking.roomId()));
     Booking booking = bookingMapper.toBooking(id, newBooking.startDate(), newBooking.endDate(), user, room);
     booking = bookingRepository.saveAndFlush(booking);
     user.addBooking(booking);
     room.addBooking(booking);
     return bookingMapper.toBookingResponseDto(booking);
 }

 @Transactional
    public void cancelBooking(long id){
     Optional<Booking> booking = bookingRepository.findById(id);
     booking.ifPresent(b -> {
         User user = b.getUser();
         user.removeBooking(b);
         Room room = b.getRoom();
         room.removeBooking(b);
         bookingRepository.delete(b);
     });
 }

//    public List<BookingResponseDto> getAllBookingByStatus(StatusBooking status){
//        List<Booking> bookings = bookingRepository.findAllByStatusBooking(status);
//        return bookings.stream()
//                .map(bookingMapper::toBookingResponseDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<BookingResponseDto> getAllBookingByUser(Long userId){
//        List<Booking> bookings = bookingRepository.findAllByUser(userRepository.getReferenceById(userId));
//        return bookings.stream()
//                .map(bookingMapper::toBookingResponseDto)
//                .collect(Collectors.toList());
//    }
//
//    public List<BookingResponseDto> getAllBookingByRoom(int roomId){
//        List<Booking> bookings = bookingRepository.findAllByRoom(roomRepository.getReferenceById(roomId));
//        return bookings.stream()
//                .map(bookingMapper::toBookingResponseDto)
//                .collect(Collectors.toList());
//    }
//
}
