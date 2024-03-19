package com.jbr.eCommercesite.service;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.model.LocalUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public LocalUser registeredUser(RegistrationBody registrationBody) {

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());


//        have to encrypt password
        user.setPassword(registrationBody.getPassword());

        return user;
    }

}
