package com.example.chatdemo.customer.dao;

import com.example.chatdemo.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImp implements CustomerDao{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findOneById(String MemNo) {
        System.out.println("findOneById:" + MemNo);
        return customerRepository.findByMemNo(MemNo);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void newOne(Customer customer) {
        customerRepository.save(customer);
    }


}
