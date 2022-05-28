package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends MongoRepository<Equipment,String> {
}

