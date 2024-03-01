package org.example.hotelbookingapplication.repository;

import org.example.hotelbookingapplication.entity.rooms.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.number NOT IN " +
            "(SELECT b.room.number FROM Booking b WHERE " +
            "(b.startDate BETWEEN :startDate AND :endDate) OR (b.endDate BETWEEN :startDate AND :endDate) " +
            "OR (b.startDate < :startDate AND b.endDate > :endDate))")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
