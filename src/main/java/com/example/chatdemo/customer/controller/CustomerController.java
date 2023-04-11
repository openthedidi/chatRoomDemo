package com.example.chatdemo.customer.controller;


import com.example.chatdemo.customer.model.Customer;
import com.example.chatdemo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("findOne/{memNo}")
    public ResponseEntity<Customer> findOne(@PathVariable String memNo){
        Customer customer =customerService.findOneById(memNo);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("newOne")
    public ResponseEntity<Customer> newOne(@RequestParam String memName,
                                           @RequestParam String memPassword,
                                           @RequestParam String memAccount,
                                           @RequestParam String memNo){
        customerService.newOne(memNo,memName,memAccount,memPassword);
        return ResponseEntity.ok(customerService.findOneById(memNo));
    }
}
