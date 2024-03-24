package com.jbr.eCommercesite.service;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.exception.UserAlreadyExistsException;
import com.jbr.eCommercesite.model.LocalUser;
import com.jbr.eCommercesite.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    When Spring creates this service it will inject the Repository interface (and its methods) into the class

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;


    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
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


//        This now uses the encryption password service above to encrypt the password from above
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));

        user = localUserDAO.save(user);

        return user;

    }

}
