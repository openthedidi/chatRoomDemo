package com.example.chatdemo.customer.dao;

import com.example.chatdemo.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerDaoImpTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findOneById() {
        Customer customer =customerRepository.findByMemNo("11008");
        assertEquals("11008",customer.getMemNo());

    }

    @Test
    void findAll() {
        List<Customer> list =customerRepository.findAll();
        for (Customer c:list) {
            System.out.println(c == null);
            System.out.println(c.getMemName());
        }
        assertEquals(4,list.size());

    }
}