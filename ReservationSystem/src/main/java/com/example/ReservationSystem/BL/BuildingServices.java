package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.repository.BuildingRepository;
import com.example.ReservationSystem.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
public class BuildingServices {
    @Autowired
    private final BuildingRepository buildingRepository;
    public BuildingServices(BuildingRepository rep)
    {this.buildingRepository=rep;}
}
