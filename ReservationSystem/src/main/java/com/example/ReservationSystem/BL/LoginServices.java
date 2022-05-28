package com.example.ReservationSystem.BL;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.example.ReservationSystem.DAO.ApiDao.CreateUser;
import com.example.ReservationSystem.DAO.MongoDao.User;
import com.example.ReservationSystem.Enums.Roles;
import com.example.ReservationSystem.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    @Autowired
    private final LoginRepository loginRepository;
    public LoginServices(LoginRepository rep)
    {this.loginRepository=rep;}
    public void create(CreateUser dtoIn)
    {
      User newUser = new User();
      
      try {
        newUser.setUserName(dtoIn.userName);
        newUser.setHashPassword(toHexString(getSHA(dtoIn.password)));
        newUser.setRole(dtoIn.role);
        loginRepository.save(newUser);
      } catch (Exception e) {
          //TODO: handle exception
      }
      
    }
    public  Boolean verifiUser(CreateUser dtoIn,Roles role)
    {
        try {
            List<User> findUsers = loginRepository.findUserByName(dtoIn.userName);
            if(findUsers.size()!=1)
            {
              if( findUsers.get(0).getRole().equals( toHexString(getSHA(dtoIn.password)))&&role==findUsers.get(0).getRole())
              return true;
              else
              return false;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return false;
    }
    private static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        // Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
        // digest() method called 
        // to calculate message digest of an input 
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    private static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
}
