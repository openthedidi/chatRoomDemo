package com.example.chatdemo.mem.model;

import com.example.chatdemo.mem.dao.MemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemDetailService implements UserDetailsService {
    @Autowired
    private MemDao memDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);

        Mem mem = memDao.getName(username);
        if(mem == null){
            throw new UsernameNotFoundException("user not found");
        }
        Collection<? extends GrantedAuthority> authorities = getAuthorities();
        System.out.println(mem.getPassword());
//        return new Mem(mem.getMemAccount(),mem.getPassword(),authorities);
        return mem;
    }






    private Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = new ArrayList<>();
        roles.add("customer");
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
