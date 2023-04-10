package com.example.chatdemo.customer.controller;


import com.example.chatdemo.customer.model.Customer;
import com.example.chatdemo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
