package com.example.chatdemo.customer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document(collection = "mem")
@Getter
@Setter
public class Customer {
    @Id
    private String id;
    @Field("MemNo")
    private String memNo;
    @Field("MemName")
    private String memName;
    @Field("MemAccount")
    private String memAccount;
    @Field("MemPassword")
    private String memPassword;

}
