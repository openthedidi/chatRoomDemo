package com.example.chatdemo.chatRoom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("CGA101G1")
public class ThymeleafController {

    @GetMapping("/chatRoom")
    public String chatRoom() {
        return "index";
    }
}
