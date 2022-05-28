package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.EquipmentTypeServices;
import com.example.ReservationSystem.DAO.MongoDao.EquipmentType;
import com.example.ReservationSystem.Exceptions.EquipmentTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/equipmentType")
public class EquipmentTypeController {
    private final EquipmentTypeServices _equipmentTypeServices;
    @Autowired
    public EquipmentTypeController(EquipmentTypeServices equipmentTypeServices)
    {
        this._equipmentTypeServices = equipmentTypeServices;
    }

    @GetMapping("/getEquipmentTypes")
    public ResponseEntity<List<EquipmentType>> getAll() {
        return new ResponseEntity<>(_equipmentTypeServices.getAll(), HttpStatus.OK);
    }

    @PostMapping("/createEquipmentType")
    public void createEquipmentType(@RequestBody EquipmentType equipmentType){
        _equipmentTypeServices.createEquipmentType(equipmentType.getName());
    }

    @GetMapping("/deleteEquipmentType")
    public void deleteEquipmentType(@RequestBody EquipmentType equipmentType){
        try {
            _equipmentTypeServices.deleteEquipmentType(equipmentType.getId());
        } catch (EquipmentTypeException be){
            System.err.println("EquipmentType not found. " + be);
        }
    }

    @PostMapping("/updateEquipmentType")
    public void updateEquipmentType(@RequestBody EquipmentType equipmentType){
        try {
            _equipmentTypeServices.updateEquipmentType(equipmentType.getId(), equipmentType.getName());
        } catch (EquipmentTypeException be){
            System.err.println("EquipmentType not found. " + be);
        }
    }

}
