package com.example.chatdemo.chatRoom;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;


@Controller
@RequestMapping("CGA101G1")
public class ThymeleafController {

    @GetMapping("/chatRoom")
    public String chatRoom(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String memAccount = userDetails.getUsername();
            model.addAttribute("name",memAccount);
        }else{
            return "login";
        }
        return "index";
    }

    @GetMapping("/error")
    public String login(Model model){
        System.out.println("登入失敗");
        model.addAttribute("error",1);
        return "login";
    }
}
