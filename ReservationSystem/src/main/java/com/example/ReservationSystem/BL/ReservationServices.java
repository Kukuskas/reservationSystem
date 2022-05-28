package com.example.ReservationSystem.BL;

import com.example.ReservationSystem.DAO.MongoDao.Equipment;
import com.example.ReservationSystem.DAO.MongoDao.Reservation;
import com.example.ReservationSystem.Exceptions.ReservationException;
import com.example.ReservationSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {
    @Autowired
    private final ReservationRepository reservationRepository;
    public ReservationServices(ReservationRepository rep)
    {this.reservationRepository=rep;}

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public void createReservation(Date startdate, Date endDate, String roomId, List<Equipment> equipmentList){
        Reservation reservation = new Reservation();
        reservation.setStartDate(startdate);
        reservation.setEndDate(endDate);
        reservation.setRoomId(roomId);
        reservation.setUsedEquipment(equipmentList);

        reservationRepository.insert(reservation);
    }

    public Reservation getReservationById(String id) throws ReservationException {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()){
            return reservation.get();
        }else{
            throw new ReservationException("Non existing reservation.");
        }
    }

    public void deleteReservation(String id) throws ReservationException {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }

    public void updateReservation(String id, Date startdate, Date endDate, String roomId, List<Equipment> equipmentList) throws ReservationException {
        Reservation reservation = getReservationById(id);
        reservation.setStartDate(startdate);
        reservation.setEndDate(endDate);
        reservation.setRoomId(roomId);
        reservation.setUsedEquipment(equipmentList);
    }

}
