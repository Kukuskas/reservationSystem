package com.example.ReservationSystem.repository;
import java.util.*;

import com.example.ReservationSystem.DAO.MongoDao.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<User,String> {
}
