package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServices {
    @Autowired
    private final RoomRepository roomRepository;
    public RoomServices(RoomRepository rep)
    {this.roomRepository=rep;}
}
