package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepository extends MongoRepository<User,String> {
}

