package com.example.ReservationSystem.BL;


import com.example.ReservationSystem.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
public class LoginServices {
    
    private final LoginRepository loginRepository;
    @Autowired
    public LoginServices(LoginRepository rep) {
        this.loginRepository = rep;
    }
    public void signIn()
    {}
    public void create()
    {
        
    }
}
