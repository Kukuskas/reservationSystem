package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;

public class Room {
    @Id
    private String id;
    private String roomName;
    private String buildingId;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public String getBuildingId() { return buildingId; }
    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

}
