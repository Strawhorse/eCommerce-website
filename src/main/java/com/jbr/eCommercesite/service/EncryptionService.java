package com.jbr.eCommercesite.service;


//Class to encrypt data and verify encrypted data
//Use Bcrypt to serialise data

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptionService {

    @Value("${encryption.salt.rounds}")
    private int saltRoundings;

//    when you generate salt to be used when hashing, it comes out as a string
//    need to create salt first

    private String salt;


    @PostConstruct
    public void postConstruct(){
        salt = BCrypt.gensalt(saltRoundings);
    }

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password,salt);
    }


//    the hash here is the previously encrypted password
    public boolean verifyPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }


}
