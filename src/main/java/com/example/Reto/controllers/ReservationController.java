package com.example.Reto.controllers;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto.entities.Reservation;
import com.example.Reto.services.ReservationService;

@Service
@RestController
@RequestMapping ("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @GetMapping ("/all")
    public ResponseEntity<List<Reservation>> getReservations(){
        return new ResponseEntity<List<Reservation>>(this.reservationService.getlistReservation(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id){
        return new ResponseEntity<Reservation>(this.reservationService.getReservation(id), HttpStatus.OK);
    }
    @PostMapping ("/save")
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation){
        this.reservationService.createReservation(reservation);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") int id){
        this.reservationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@PathVariable("id") int id, @RequestBody Reservation reservation){
        this.reservationService.updateReservation(id, reservation);
        return new ResponseEntity<String>("Reservation updated", HttpStatus.CREATED);
    }    
    
} 
