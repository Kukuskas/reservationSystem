package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.DAO.MongoDao.UserGroup;
import com.example.ReservationSystem.Exceptions.UserGroupException;
import com.example.ReservationSystem.repository.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupServices {
    @Autowired
    private final UserGroupRepository userGroupRepository;
    public UserGroupServices(UserGroupRepository rep)
    {this.userGroupRepository=rep;}

    public void createUserGroup(String name){
        UserGroup userGroup = new UserGroup();
        userGroup.setName(name);
        userGroupRepository.insert(userGroup);
    }

    public List<UserGroup> getAll(){
        return userGroupRepository.findAll();
    }

    public UserGroup getUserGroupById(String id) throws UserGroupException {
        Optional<UserGroup> userGroup = userGroupRepository.findById(id);
        if (userGroup.isPresent()){
            return userGroup.get();
        }else{
            throw new UserGroupException("Non existing userGroup.");
        }
    }

    public void deleteUserGroup(String id) throws UserGroupException {
        userGroupRepository.delete(getUserGroupById(id));
    }

    public void updateUserGroup(String id, String name, String roomId, String equipmentId) throws UserGroupException {
        UserGroup userGroup = this.getUserGroupById(id);
        userGroup.setName(name);
        userGroup.setRestrictedRoom(roomId);
        userGroup.setRestrictedEquipment(equipmentId);
        userGroupRepository.save(userGroup);
    }
}
