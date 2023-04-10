package com.example.chatdemo.mem.dao;


import com.example.chatdemo.mem.model.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemDaoImp implements MemDao{

    @Autowired
    private MemRepository memRepository;


    @Override
    public Mem getName(String memAccount) {
        return memRepository.getMemByAccount(memAccount);
    }
}
