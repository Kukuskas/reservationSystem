package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.UserGroupServices;
import com.example.ReservationSystem.DAO.MongoDao.UserGroup;
import com.example.ReservationSystem.Exceptions.UserGroupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userGroup")
public class UserGroupController {
    private final UserGroupServices _userGroupServices;
    @Autowired
    public UserGroupController(UserGroupServices userGroupServices)
    {
        this._userGroupServices = userGroupServices;
    }

    @GetMapping("/getUserGroups")
    public ResponseEntity<List<UserGroup>> getAll() {
        return new ResponseEntity<>(_userGroupServices.getAll(), HttpStatus.OK);
    }

    @PostMapping("/createUserGroup")
    public void createUserGroup(@RequestBody UserGroup userGroup){
        _userGroupServices.createUserGroup(userGroup.getName());
    }

    @PostMapping("/deleteUserGroup")
    public void deleteUserGroup(@RequestBody UserGroup userGroup){
        try {
            _userGroupServices.deleteUserGroup(userGroup.getId());
        } catch (UserGroupException be){
            System.err.println("UserGroup not found. " + be);
        }
    }

    @PostMapping("/updateUserGroup")
    public void updateUserGroup(@RequestBody UserGroup userGroup){
        try {
          _userGroupServices.updateUserGroup(
            userGroup.getId(),
            userGroup.getRestrictedRoom(),
            userGroup.getRestrictedEquipment(),
            userGroup.getName()
          );
        } catch (UserGroupException be){
            System.err.println("UserGroup not found. " + be);
        }
    }

}
