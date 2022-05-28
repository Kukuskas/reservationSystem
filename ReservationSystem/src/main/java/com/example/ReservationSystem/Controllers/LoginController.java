package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.LoginServices;
import com.example.ReservationSystem.DAO.ApiDao.CreateUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    private final LoginServices _loginServices;
	@Autowired
	public  LoginController(LoginServices loginServices)
    {
        this._loginServices = loginServices;
    }
    @GetMapping("/hello")
    public String hello()
    {
        return "hi";
    }

    
    @PostMapping("/login/create")
    public void create(@RequestBody CreateUser user)
    {
        _loginServices.create(user);
    }
}
