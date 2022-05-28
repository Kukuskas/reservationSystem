package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.EquipmentServices;
import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.DAO.MongoDao.Equipment;
import com.example.ReservationSystem.Exceptions.BuildingException;
import com.example.ReservationSystem.Exceptions.EquipmentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/equipment")
public class EquipmentController {
    private final EquipmentServices _equipmentServices;
    @Autowired
    public  EquipmentController(EquipmentServices equipmentServices)
    {
        this._equipmentServices = equipmentServices;
    }

    @GetMapping("/getEquipment")
    public ResponseEntity<List<Equipment>> getAll() {
        return new ResponseEntity<>(_equipmentServices.getAll(), HttpStatus.OK);
    }
    @PostMapping("/createEquipment")
    public void createEquipment(@RequestBody Equipment equipment){
        _equipmentServices.createEquipment(equipment.getName(), equipment.getType());
    }

    @PostMapping("/deleteEquipment")
    public void deleteEquipment(@RequestBody Equipment equipment){
        try {
            _equipmentServices.deleteEquipment(equipment.getId());
        } catch (EquipmentException ee){
            System.err.println("Equipment not found. " + ee);
        }
    }

    @PostMapping("/updateEquipment")
    public void updateEquipment(@RequestBody Equipment equipment){
        try {
            _equipmentServices.updateEquipment(equipment.getId(), equipment.getName(), equipment.getType());
        } catch (EquipmentException ee){
            System.err.println("Building not found. " + ee);
        }
    }
}
