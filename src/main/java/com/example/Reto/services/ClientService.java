package com.example.Reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto.entities.Client;
import com.example.Reto.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Metodos CRUD

    public List<Client> getlistClient() {
        return this.clientRepository.findAll();
    }

    public Client getClient(int id) {
        if (!this.clientRepository.findById(id).isEmpty()) {

            return this.clientRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }

    public void deleteClient(int id) {
        if (!this.clientRepository.findById(id).isEmpty()) {

            this.clientRepository.deleteById(id);
        }
    }

    public void updateClient(int id, Client client) {

        Client clientDB = this.clientRepository.findById(id).get();

        if (!this.clientRepository.findById(id).isEmpty()) {
            if(client.getName() != null){
                clientDB.setName((client.getName()));
            }
            if(client.getEmail() != null){
                clientDB.setEmail(client.getEmail());
            }
            if(client.getAge() != null){
                clientDB.setAge((client.getAge()));
            }

            this.clientRepository.save(clientDB);
        }
    }

}
