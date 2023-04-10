package com.example.chatdemo.mem.dao;

import com.example.chatdemo.mem.model.Mem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemRepository extends CrudRepository<Mem,Integer> {

    @Query(value = "select * from mem where memAccount = ?1",nativeQuery = true)
    Mem getMemByAccount(String memAccount);
}
