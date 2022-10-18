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

import com.example.Reto.entities.Message;
import com.example.Reto.services.MessageService;

@Service
@RestController
@RequestMapping ("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @GetMapping ("/all")
    public ResponseEntity<List<Message>> getMessages(){
        return new ResponseEntity<List<Message>>(this.messageService.getlistMessage(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") int id){
        return new ResponseEntity<Message>(this.messageService.getMessage(id), HttpStatus.OK);
    }
    @PostMapping ("/save")
    public ResponseEntity<Void> createMessage(@RequestBody Message message){
        this.messageService.createMessage(message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id){
        this.messageService.deleteMessage(id);
        return new ResponseEntity<String>("Message deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMessage(@RequestBody Message message){
        this.messageService.updateMessage(message.getIdMessage(),message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }    
    
} 
