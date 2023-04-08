package com.example.chatdemo.chatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;


    @MessageMapping("/destination")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        // 將消息存儲到 Redis
        messageRepository.save(message);

        // 將消息發送給所有訂閱者
        return message;
    }
}
