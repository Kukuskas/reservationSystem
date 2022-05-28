package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;

public class Equipment {
    @Id
    private String id;

    private String name;

    private EquipmentType type;

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

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }
}
