package com.example.ReservationSystem.DAO.MongoDao;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String userName;
    private String hashPassword;
    
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
