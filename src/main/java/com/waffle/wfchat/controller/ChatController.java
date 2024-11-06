package com.waffle.wfchat.controller;

import com.waffle.wfchat.entity.Message;
import com.waffle.wfchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final ChatService chatService;


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message message) {
        chatService.sendMessage(message.getSender(), message.getContent());
        log.info("sender : {}, message : {}", message.getSender(), message.getContent());
        return message;
    }
}
