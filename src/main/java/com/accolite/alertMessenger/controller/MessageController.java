package com.accolite.alertMessenger.controller;

import com.accolite.alertMessenger.model.Message;
import com.accolite.alertMessenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accolite/alertmessenger")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/saveData")
    public ResponseEntity<Message> save(@RequestBody Message message){
        return new ResponseEntity<Message>(messageService.save(message), HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetchData")
    public List<Message> getData(){
        return messageService.getData();
    }

    @DeleteMapping(value="/deleteData/{id}")
    public void delete(@PathVariable("id") int id){
        messageService.delete(id);
    }

    @PutMapping(value = "/updateData/{id}")
    public ResponseEntity<Message> updateMessage(@RequestBody Message newMessage, @PathVariable("id") int id){
        return new ResponseEntity<Message>(messageService.update(newMessage, id),HttpStatus.ACCEPTED);
    }

}
