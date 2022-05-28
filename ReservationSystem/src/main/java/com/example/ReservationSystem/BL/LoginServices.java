package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    @Autowired
    private final LoginRepository loginRepository;
    public LoginServices(LoginRepository rep)
    {this.loginRepository=rep;}
}
