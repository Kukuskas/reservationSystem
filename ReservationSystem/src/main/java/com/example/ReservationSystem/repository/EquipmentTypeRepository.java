package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.EquipmentType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTypeRepository extends MongoRepository<EquipmentType,String> {
}

