package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
public class LoginServices {
    @Autowired
    private final LoginRepository loginRepository;
    public LoginServices(LoginRepository rep)
    {this.loginRepository=rep;}
}
