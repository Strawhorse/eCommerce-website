package com.jbr.eCommercesite.service;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.exception.UserAlreadyExistsException;
import com.jbr.eCommercesite.model.LocalUser;
import com.jbr.eCommercesite.model.dao.LocalUserDAO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    When Spring creates this service it will inject the Repository interface (and its methods) into the class

    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

//    service for creating new instances of the LocalUser to add to database




    public LocalUser registeredUser(RegistrationBody registrationBody)  throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
            || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());


//        have to encrypt password
        user.setPassword(registrationBody.getPassword());

        user = localUserDAO.save(user);

        return user;

    }

}
