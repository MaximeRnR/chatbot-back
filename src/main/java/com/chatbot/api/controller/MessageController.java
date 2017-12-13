package com.chatbot.api.controller;

import com.chatbot.api.model.Message;
import com.chatbot.api.service.ChatBotService;
import com.chatbot.api.util.ChatBotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * Created by MaximeRnR on 30/11/17.
 */
@RestController
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping("/api/chatbot")
public class MessageController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping(value = "/send")
    public ResponseEntity<?> getBotResponse(@RequestBody Message message) {
        try {
            return new ResponseEntity<>(chatBotService.sendMessageAndGetBotResponse(message.getText()),HttpStatus.OK);
        } catch (ChatBotException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


}
