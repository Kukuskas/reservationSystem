package com.example.ReservationSystem.BL;

import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.DAO.MongoDao.Equipment;
import com.example.ReservationSystem.DAO.MongoDao.EquipmentType;
import com.example.ReservationSystem.Exceptions.BuildingException;
import com.example.ReservationSystem.Exceptions.EquipmentException;
import com.example.ReservationSystem.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServices {
    @Autowired
    private final EquipmentRepository equipmentRepository;
    public EquipmentServices(EquipmentRepository rep)
    {this.equipmentRepository=rep;}

    public List<Equipment> getAll(){
        return equipmentRepository.findAll();
    }

    public void createEquipment(String name, EquipmentType type){
        Equipment equipment = new Equipment();
        equipment.setName(name);
        equipment.setType(type);
        equipmentRepository.insert(equipment);
    }

    public Equipment getEquipmentById(String id) throws EquipmentException {
        Optional<Equipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent()){
            return equipment.get();
        }else{
            throw new EquipmentException("Non existing equipment.");
        }
    }

    public void deleteEquipment(String id) throws EquipmentException {
        Equipment equipment = getEquipmentById(id);
        equipmentRepository.delete(equipment);
    }

    public void updateEquipment(String id, String name, EquipmentType type) throws EquipmentException {
        Equipment equipment = getEquipmentById(id);
        equipment.setName(name);
        equipment.setType(type);
        equipmentRepository.save(equipment);
    }

}
