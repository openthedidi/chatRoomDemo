package com.example.chatdemo.customer.dao;

import com.example.chatdemo.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    @Query("{'MemNo':'?0'}")
    Customer findByMemNo(String MemNo);
}
