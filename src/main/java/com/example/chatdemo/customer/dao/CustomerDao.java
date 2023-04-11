package com.example.chatdemo.customer.dao;

import com.example.chatdemo.customer.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer findOneById(String memNo);
    List<Customer> findAll();
    void newOne(Customer customer);
}
