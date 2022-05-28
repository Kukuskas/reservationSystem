package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.Exceptions.BuildingException;
import com.example.ReservationSystem.repository.BuildingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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

    public Building getBuildingById(String id) throws BuildingException {
        Optional<Building> building = buildingRepository.findById(id);
        if (building.isPresent()){
            return building.get();
        }else{
            throw new BuildingException("Non existing building.");
        }
    }

    public void deleteBuilding(String id) throws BuildingException {
        buildingRepository.delete(getBuildingById(id));
    }

    public void updateBuilding(String id, String location) throws BuildingException {
        Building building = this.getBuildingById(id);
        building.setLocation(location);
        buildingRepository.save(building);
    }
}
