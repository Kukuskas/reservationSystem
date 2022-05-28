package com.example.ReservationSystem.Controllers;


import com.example.ReservationSystem.BL.LoginServices;
import com.example.ReservationSystem.DAO.ApiDao.CreateUser;
import com.example.ReservationSystem.DAO.ApiDao.signIdDtoIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
public class LoginController {
   
    private final LoginServices _loginServices;
    @Autowired
	public  LoginController(LoginServices loginServices)
    {
        this._loginServices = loginServices;
    }
    
    @GetMapping
    public String getHello() {
        return "hi";
    }
    @PostMapping("/login/singin")
    public void signIn(@RequestBody signIdDtoIn dtoIn)
    {
        this._loginServices.signIn();
    }
    @PostMapping("/login/create")
    public void create(@RequestBody CreateUser dtoIn)
    {
        this._loginServices.create();
    }
}
