package com.example.Reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reto.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer>{ 
    
}
