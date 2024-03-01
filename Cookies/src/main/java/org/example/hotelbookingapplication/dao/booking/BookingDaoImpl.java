package org.example.hotelbookingapplication.dao.booking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.booking.StatusBooking;
import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.rooms.TypeByCountPerson;
import org.example.hotelbookingapplication.entity.rooms.TypeBySize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookingDaoImpl implements BookingDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Booking create(Booking booking) {
        Objects.requireNonNull(booking);
        booking.setStatusBooking(StatusBooking.NEW);
        booking.setBookDate(LocalDate.now());
        entityManager.persist(booking);
        return booking;
    }

    @Override
    public Booking read(long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public List<Booking> readAll() {
        return entityManager.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();
    }

    @Override
    @Transactional
    public Booking update(Booking booking, long id) {
        Objects.requireNonNull(booking);
        booking.setId(id);
        return entityManager.merge(booking);
    }

    @Override
    public void delete(long id) {
        Optional.ofNullable(read(id)).ifPresent(u -> entityManager.remove(u));
    }

    @Override
    public List<Room> readAllAvailable(LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery("SELECT r FROM Room r LEFT JOIN Booking b on b.room.id = r.id " +
                                "WHERE (b.endDate is null and b.startDate is null) or b.endDate < :endDate and b.startDate > :startDate",
                        Room.class)
                .setParameter("endDate", endDate)
                .setParameter("startDate", startDate)
                .getResultList();
    }

    @Override
    public List<Room> readAllAvailableWithFilter(TypeByCountPerson typeByCountPerson, TypeBySize typeBySize,
                                                 LocalDate startDate, LocalDate endDate) {
        return readAllAvailable(startDate, endDate).stream()
                .filter(r->r.getTypeByCountPerson().equals(typeByCountPerson)&&
                        r.getTypeBySize().equals(typeBySize)).collect(Collectors.toList());
    }
}
