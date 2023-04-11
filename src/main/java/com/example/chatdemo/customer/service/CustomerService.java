package com.example.chatdemo.customer.service;

import com.example.chatdemo.customer.model.Customer;

public interface CustomerService {
    Customer findOneById(String memNo);
    void newOne(String memNo, String memName, String memAccount, String memPassword);
}
