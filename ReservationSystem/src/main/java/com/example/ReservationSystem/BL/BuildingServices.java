package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.Exceptions.BuildingException;
import com.example.ReservationSystem.repository.BuildingRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BuildingServices {
    @Autowired
    private final BuildingRepository buildingRepository;
    public BuildingServices(BuildingRepository rep)
    {this.buildingRepository=rep;}

    public String getLocation(String id) throws BuildingException {
        Optional<Building> building = buildingRepository.findById(id);
        if (building.isPresent()){
            return building.get().getLocation();
        }else{
            throw new BuildingException("Non existing building.");
        }
    }

    public void createBuilding(String location){
        Building building = new Building();
        building.setLocation(location);
        buildingRepository.insert(building);
    }

    public List<Building> getAll(){
        return buildingRepository.findAll();
    }
}
