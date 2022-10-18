package com.example.Reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reto.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Integer>{ 
    
}
