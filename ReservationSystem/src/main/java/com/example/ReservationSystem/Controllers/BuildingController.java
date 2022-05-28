package com.example.ReservationSystem.Controllers;

import com.example.ReservationSystem.BL.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {
    private final LoginServices _loginServices;
    @Autowired
    public  BuildingController(LoginServices loginServices)
    {
        this._loginServices = loginServices;
    }

}
