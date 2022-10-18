package com.example.Reto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto.entities.Message;
import com.example.Reto.repositories.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Metodos CRUD

    public List<Message> getlistMessage() {
        return this.messageRepository.findAll();
    }

    public Message getMessage(int id) {
        if (!this.messageRepository.findById(id).isEmpty()) {

            return this.messageRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Message createMessage(Message message) {
        return this.messageRepository.save(message);
    }

    public void deleteMessage(int id) {
        if (!this.messageRepository.findById(id).isEmpty()) {

            this.messageRepository.deleteById(id);
        }
    }

    public void updateMessage(int id, Message message) {

        Message messageDB = this.messageRepository.findById(id).get();

        if (!this.messageRepository.findById(id).isEmpty()) {
            if(message.getMessageText() != null){
                messageDB.setMessageText((message.getMessageText()));
            }

            this.messageRepository.save(messageDB);
        }
    }

}
