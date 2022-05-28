package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.DAO.MongoDao.EquipmentType;
import com.example.ReservationSystem.Exceptions.EquipmentTypeException;
import com.example.ReservationSystem.repository.EquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentTypeServices {
    @Autowired
    private final EquipmentTypeRepository equipmentTypeRepository;
    public EquipmentTypeServices(EquipmentTypeRepository rep)
    {this.equipmentTypeRepository=rep;}

    public void createEquipmentType(String name){
        EquipmentType equipmentType = new EquipmentType();
        equipmentType.setName(name);
        equipmentTypeRepository.insert(equipmentType);
    }

    public List<EquipmentType> getAll(){
        return equipmentTypeRepository.findAll();
    }

    public EquipmentType getEquipmentTypeById(String id) throws EquipmentTypeException {
        Optional<EquipmentType> equipmentType = equipmentTypeRepository.findById(id);
        if (equipmentType.isPresent()){
            return equipmentType.get();
        }else{
            throw new EquipmentTypeException("Non existing equipmentType.");
        }
    }

    public void deleteEquipmentType(String id) throws EquipmentTypeException {
        equipmentTypeRepository.delete(getEquipmentTypeById(id));
    }

    public void updateEquipmentType(String id, String name) throws EquipmentTypeException {
        EquipmentType equipmentType = this.getEquipmentTypeById(id);
        equipmentType.setName(name);
        equipmentTypeRepository.save(equipmentType);
    }
}
