package com.example.Reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reto.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer>{ 
    
}
