package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.LoginServices;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginController {
    private final LoginServices _loginServices;
	@Autowired
	public  LoginController(LoginServices loginServices)
    {
        this._loginServices = loginServices;
    }
}
