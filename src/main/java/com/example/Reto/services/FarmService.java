package com.example.Reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto.entities.Farm;
import com.example.Reto.repositories.FarmRepository;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    // Metodos CRUD

    public List<Farm> getlistFarm() {
        return this.farmRepository.findAll();
    }

    public Farm getFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {

            return this.farmRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Farm createFarm(Farm farm) {
        return this.farmRepository.save(farm);
    }

    public void deleteFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {

            this.farmRepository.deleteById(id);
        }
    }

    public void updateFarm(int id, Farm farm) {

        Farm farmDB = this.farmRepository.findById(id).get();

        if (!this.farmRepository.findById(id).isEmpty()) {
            if(farm.getAddress() != null){
                farmDB.setAddress(farm.getAddress());
            }
            if(farm.getExtension() != null){
                farmDB.setExtension(farm.getExtension());
            }
            if(farm.getName() != null){
                farmDB.setName(farm.getName());
            }
            if(farm.getDescription() != null){
                farmDB.setDescription(farm.getDescription());
            }
            this.farmRepository.save(farmDB);
        }
    }

}
