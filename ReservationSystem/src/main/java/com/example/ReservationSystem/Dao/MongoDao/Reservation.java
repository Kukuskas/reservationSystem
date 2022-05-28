package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Reservation {
    @Id
    private String id;

    private Date startDate;

    private Date endDate;

    private String userId;

    private String roomId;

    private List<Equipment> usedEquipment;
}
