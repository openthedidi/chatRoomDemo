package com.example.chatdemo.chatRoom;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String>{
}
