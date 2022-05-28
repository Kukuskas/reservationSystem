package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
}
