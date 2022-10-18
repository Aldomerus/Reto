package com.example.Reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reto.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository <Message, Integer>{ 
    
}
