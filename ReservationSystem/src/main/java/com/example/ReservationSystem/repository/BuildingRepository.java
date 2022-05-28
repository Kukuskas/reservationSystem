package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends MongoRepository<Building,String> {
}

