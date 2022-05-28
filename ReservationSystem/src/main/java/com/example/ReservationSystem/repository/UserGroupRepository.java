package com.example.ReservationSystem.repository;

import com.example.ReservationSystem.DAO.MongoDao.UserGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends MongoRepository<UserGroup,String> {
}

