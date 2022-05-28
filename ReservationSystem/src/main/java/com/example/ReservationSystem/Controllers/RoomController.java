package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.RoomServices;

import com.example.ReservationSystem.DAO.MongoDao.Room;
import com.example.ReservationSystem.Exceptions.RoomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
  private final RoomServices _roomServices;
  @Autowired
  public  RoomController(RoomServices roomServices)
  {
    this._roomServices = roomServices;
  }
  @GetMapping("/getRooms")
  public ResponseEntity<List<Room>> getAll() {
    return new ResponseEntity<>(_roomServices.getAll(), HttpStatus.OK);
  }

  @GetMapping(value="/getRoomBuilding/{id}")
  public String getRoomLocation(String id){
    String location = "";
    try {
      location = _roomServices.getBuildingId(id);
    } catch (RoomException be){
      System.err.println("Room not found. " + be);
    }
    return location;
  }

  @PostMapping("/createRoom/{buildingId}")
  public void createRoom(String buildingId){
    _roomServices.createRoom(buildingId);
  }

  @GetMapping("/deleteRoom/{id}")
  public void deleteRoom(String id){
    try {
      _roomServices.deleteRoom(id);
    } catch (RoomException be){
      System.err.println("Room not found. " + be);
    }
  }

  @PostMapping("/updateRoom/{id}")
  public void updateRoom(String id, Room room, String name){
    try {
      _roomServices.updateRoom(id, room.getBuildingId(), name);
    } catch (RoomException be){
      System.err.println("Room not found. " + be);
    }
  }

}


