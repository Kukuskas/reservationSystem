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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Equipment> getUsedEquipment() {
        return usedEquipment;
    }

    public void setUsedEquipment(List<Equipment> usedEquipment) {
        this.usedEquipment = usedEquipment;
    }
}
