package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;
import com.example.ReservationSystem.Enums.Roles;
public class User {
    @Id
    private String id;
    private String userName;
    private String hashPassword;
    private Roles role;
    
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getHashPassword() {
        return hashPassword;
    }
    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
    
}
