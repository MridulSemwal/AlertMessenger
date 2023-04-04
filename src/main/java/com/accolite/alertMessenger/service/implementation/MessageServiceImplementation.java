package com.accolite.alertMessenger.service.implementation;

import com.accolite.alertMessenger.model.Message;
import com.accolite.alertMessenger.repository.MessageRepo;
import com.accolite.alertMessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public MessageServiceImplementation(MessageRepo messageRepo){
        this.messageRepo = messageRepo;
    }

    @Override
    public Message save(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public List<Message> getData() {
        return messageRepo.findAll();
    }

    @Override
    public void delete(int id) {
        messageRepo.deleteById(id);
    }

    @Override
    public Message update(Message newMessage, int id) {
        return messageRepo.findById(id)
                .map(message ->{
                    message.setMessage_id(newMessage.getMessage_id());
                    message.setMessage_title(newMessage.getMessage_title());
                    return messageRepo.save(newMessage);
                })
                .orElseGet(()->{
                    return messageRepo.save(newMessage);
                });
    }
}
