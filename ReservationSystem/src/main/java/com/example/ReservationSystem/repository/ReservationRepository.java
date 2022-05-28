package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation,String> {
}
