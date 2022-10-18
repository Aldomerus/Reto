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

import com.example.Reto.entities.Farm;
import com.example.Reto.services.FarmService;

@Service
@RestController
@RequestMapping ("/api/Farm")
public class FarmController {

    @Autowired
    FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }
    
    @GetMapping ("/all")
    public ResponseEntity<List<Farm>> getFarms(){
        return new ResponseEntity<List<Farm>>(this.farmService.getlistFarm(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable("id") int id){
        return new ResponseEntity<Farm>(this.farmService.getFarm(id), HttpStatus.OK);
    }
    @PostMapping ("/save")
    public ResponseEntity<Void> createFarm(@RequestBody Farm farm){
        this.farmService.createFarm(farm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarm(@PathVariable("id") int id){
        this.farmService.deleteFarm(id);
        return new ResponseEntity<String>("Farm deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFarm(@RequestBody Farm farm){
        this.farmService.updateFarm(farm.getId(), farm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }    
    
} 
