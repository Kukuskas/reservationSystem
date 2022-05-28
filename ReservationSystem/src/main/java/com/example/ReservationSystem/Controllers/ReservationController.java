package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.BuildingServices;
import com.example.ReservationSystem.BL.ReservationServices;
import com.example.ReservationSystem.DAO.MongoDao.Building;
import com.example.ReservationSystem.DAO.MongoDao.Reservation;
import com.example.ReservationSystem.Exceptions.BuildingException;
import com.example.ReservationSystem.Exceptions.ReservationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {
    private final ReservationServices _reservationServices;
    @Autowired
    public  ReservationController(ReservationServices reservationServices)
    {
        this._reservationServices = reservationServices;
    }

    @GetMapping("/getReservations")
    public ResponseEntity<List<Reservation>> getAll() {
        return new ResponseEntity<>(_reservationServices.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/getReservationById")
    public Reservation getBuildingLocation(@RequestBody Reservation reservation){
        try {
            return _reservationServices.getReservationById(reservation.getId());
        } catch (ReservationException re){
            System.err.println("Reservation not found. " + re);
        }
        return null;
    }

    @PostMapping("/createReservation")
    public void createReservation(@RequestBody Reservation reservation) {
        _reservationServices.createReservation(reservation.getStartDate(), reservation.getEndDate(),
                reservation.getRoomId(), reservation.getUsedEquipment());
    }

    @PostMapping("/deleteReservation")
    public void deleteReservation(@RequestBody Reservation reservation){
        try {
            _reservationServices.deleteReservation(reservation.getId());
        } catch (ReservationException re){
            System.err.println("Reservation not found. " + re);
        }
    }

    @PostMapping("/updateReservation")
    public void updateBuilding(@RequestBody Reservation reservation){
        try {
            _reservationServices.updateReservation(reservation.getId(), reservation.getStartDate(),
                    reservation.getEndDate(), reservation.getRoomId(), reservation.getUsedEquipment());
        } catch (ReservationException re){
            System.err.println("Reservation not found. " + re);
        }
    }

}
