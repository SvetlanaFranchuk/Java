package org.example.hotelbookingapplication.repository;

import org.example.hotelbookingapplication.entity.rooms.Room;
import org.example.hotelbookingapplication.entity.rooms.TypeByCountPerson;
import org.example.hotelbookingapplication.entity.rooms.TypeBySize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
