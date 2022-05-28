package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.DAO.MongoDao.Room;
import com.example.ReservationSystem.Exceptions.RoomException;
import com.example.ReservationSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServices {
  @Autowired
  private final RoomRepository roomRepository;
  public RoomServices(RoomRepository rep)
  {this.roomRepository=rep;}

  public String getBuildingId(String id) throws RoomException {
    Optional<Room> room = roomRepository.findById(id);
    if (room.isPresent()){
      return room.get().getBuildingId();
    }else{
      throw new RoomException("Non existing room.");
    }
  }

  public void createRoom(String buildingId){
    Room room = new Room();
    room.setBuildingId(buildingId);
    roomRepository.insert(room);
  }

  public List<Room> getAll(){
    return roomRepository.findAll();
  }

  public Room getRoomById(String id) throws RoomException {
    Optional<Room> room = roomRepository.findById(id);
    if (room.isPresent()){
      return room.get();
    }else{
      throw new RoomException("Non existing room.");
    }
  }

  public void deleteRoom(String id) throws RoomException {
    roomRepository.delete(getRoomById(id));
  }

  public void updateRoom(String id, String buildingId, String name) throws RoomException {
    Room room = this.getRoomById(id);
    room.setBuildingId(buildingId);
    room.setRoomName(name);
    roomRepository.save(room);
  }
}
