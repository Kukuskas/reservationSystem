package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;

public class UserGroup {

    @Id
    private String id;
    private String restrictedRoom;
    private String restrictedEquipment;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
    return name;
  }

    public void setName(String name) {
    this.name = name;
  }

    public String getRestrictedRoom() {
        return restrictedRoom;
    }

    public void setRestrictedRoom(String restrictedRoom) {
        this.restrictedRoom = restrictedRoom;
    }

    public String getRestrictedEquipment() {
    return restrictedEquipment;
  }

    public void setRestrictedEquipment(String restrictedEquipment) {
    this.restrictedEquipment = restrictedEquipment;
  }
}
