package com.example.Reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reto.entities.Farm;

@Repository
public interface FarmRepository extends JpaRepository <Farm, Integer>{ 
    
}