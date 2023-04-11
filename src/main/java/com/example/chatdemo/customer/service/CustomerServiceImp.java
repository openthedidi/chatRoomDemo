package com.example.chatdemo.customer.service;

import com.example.chatdemo.customer.dao.CustomerDao;
import com.example.chatdemo.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerDao customerDao;


    @Override
    public Customer findOneById(String memNo) {
        return customerDao.findOneById(memNo);
    }

    @Override
    public void newOne(String memNo, String memName, String memAccount, String memPassword) {
        Customer customer = new Customer();
        customer.setMemAccount(memAccount);
        customer.setMemName(memName);
        customer.setMemNo(memNo);
        customer.setMemPassword(memPassword);
        customerDao.newOne(customer);
    }
}
