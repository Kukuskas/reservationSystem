package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.BuildingServices;
import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.Exceptions.BuildingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/building")
public class BuildingController {
    private final BuildingServices _buildingServices;
    @Autowired
    public  BuildingController(BuildingServices buildingServices)
    {
        this._buildingServices = buildingServices;
    }

    @GetMapping("/getBuildings")
    public ResponseEntity<List<Building>> getAll() {
        return new ResponseEntity<>(_buildingServices.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/getBuildingLocation")
    public String getBuildingLocation(@RequestBody Building building){
        String location = "";
        try {
            location = _buildingServices.getLocation(building.getId());
        } catch (BuildingException be){
            System.err.println("Building not found. " + be);
        }
        return location;
    }

    @PostMapping("/createBuilding")
    public void createBuilding(@RequestBody Building building){
        _buildingServices.createBuilding(building.getLocation());
    }

    @PostMapping("/deleteBuilding")
    public void deleteBuilding(@RequestBody Building building){
        try {
            _buildingServices.deleteBuilding(building.getId());
        } catch (BuildingException be){
            System.err.println("Building not found. " + be);
        }
    }

    @PostMapping("/updateBuilding")
    public void updateBuilding(@RequestBody Building building){
        try {
            _buildingServices.updateBuilding(building.getId(), building.getLocation());
        } catch (BuildingException be){
            System.err.println("Building not found. " + be);
        }
    }

}
