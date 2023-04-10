package com.example.chatdemo.mem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;

@Component
@Entity
@Table(name = "mem")
@Getter
@Setter
public class Mem implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memNo;
    //    @NotNull(message = "MemAccount不可為null")
//    @NotBlank(message = "MemAccount不可是空白")
    private String memAccount;
    //    @NotNull(message = "Password不可為null")
//    @NotBlank(message = "Password不可是空白")
    private String memPassword;
    private Integer memStatus;
    private Integer memVrfed;
    private Date memNoVrftime;
    private String memName;

    @Pattern(regexp = "^09[0-9]{8}", message = "手機格式不正確")
    private String memMobile;
    private String memCity;
    private String memDist;
    private String memAdd;
    @Email
    @NotNull(message = "Email需填寫")
    private String memEmail;
    @Column(name = "MemBirth")
    private Date memBirth;
    @Column(name = "MemJoinTime")
    private Date memJoinTime;
    @Column(name = "CreditcardNo")
    private String creditcardNo;
    @Column(name = "CreditcardDate")
    private String creditcardDate;
    @Column(name = "CreditcardSecurityNo")
    private String creditcardSecurityNo;
    @Column(name = "BankAccount")
    private String bankAccount;
    @Column(name = "BankAccountOwner")
    private String bankAccountOwner;
    @Column(name = "UserStatus")
    private Integer userStatus;
    @Column(name = "MyPic")
    private byte[] myPic;
    @Column(name = "IsMute")
    private Integer isMute;

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public Mem(String memName, String memPassword, Collection<? extends GrantedAuthority> authorities) {
        this.memName = memName;
        this.memPassword = memPassword;
        this.authorities = authorities;
    }

    public Mem() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder().encode(memPassword);
    }

    @Override
    public String getUsername() {
        return memName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}