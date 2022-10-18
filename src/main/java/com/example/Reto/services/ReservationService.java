package com.example.Reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto.entities.Reservation;
import com.example.Reto.repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Metodos CRUD

    public List<Reservation> getlistReservation() {
        return this.reservationRepository.findAll();
    }

    public Reservation getReservation(int id) {
        if (!this.reservationRepository.findById(id).isEmpty()) {

            return this.reservationRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    public void deleteReservation(int id) {
        if (!this.reservationRepository.findById(id).isEmpty()) {

            this.reservationRepository.deleteById(id);
        }
    }

    public void updateReservation(int id, Reservation reservation) {

        Reservation reservationDB = this.reservationRepository.findById(id).get();

        if (!this.reservationRepository.findById(id).isEmpty()) {
            if(reservation.getStartDate() != null){
                reservationDB.setStartDate(reservation.getStartDate());
            }
            if(reservation.getDevolutionDate() != null){
                reservationDB.setDevolutionDate(reservation.getDevolutionDate());
            }

            
            this.reservationRepository.save(reservationDB);
        }
    }

}
