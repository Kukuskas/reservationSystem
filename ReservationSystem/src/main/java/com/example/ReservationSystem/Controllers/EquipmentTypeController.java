package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.EquipmentTypeServices;
import com.example.ReservationSystem.DAO.MongoDao.EquipmentType;
import com.example.ReservationSystem.Exceptions.EquipmentTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/createEquipmentType/{name}")
    public void createEquipmentType(String name){
        _equipmentTypeServices.createEquipmentType(name);
    }

    @GetMapping("/deleteEquipmentType/{id}")
    public void deleteEquipmentType(String id){
        try {
            _equipmentTypeServices.deleteEquipmentType(id);
        } catch (EquipmentTypeException be){
            System.err.println("EquipmentType not found. " + be);
        }
    }

    @PostMapping("/updateEquipmentType/{id}")
    public void updateEquipmentType(String id, EquipmentType equipmentType){
        try {
            _equipmentTypeServices.updateEquipmentType(id, equipmentType.getName());
        } catch (EquipmentTypeException be){
            System.err.println("EquipmentType not found. " + be);
        }
    }

}
