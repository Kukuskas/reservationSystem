package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.BuildingServices;
import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.Exceptions.BuildingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @GetMapping(value="/getBuildingLocation/{id}")
    public String getBuildingLocation(String id){
        String location = "";
        try {
            location = _buildingServices.getLocation(id);
        } catch (BuildingException be){
            System.err.println("Building not found. " + be);
        }
        return location;
    }

}
