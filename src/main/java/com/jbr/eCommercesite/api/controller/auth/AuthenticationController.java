package com.jbr.eCommercesite.api.controller.auth;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.exception.UserAlreadyExistsException;
import com.jbr.eCommercesite.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }






    //    method to register user so the return type is a boolean - just set it to void for now until we complete api
//    can test doing a POST request on Postman to http://localhost:8080/auth/register
//    payload below will be a RegistrationBody class and then set to Body -> raw -> json and send {} object with RegistrationBody parameters inside
//    then uses the userService object to register the user in the database

    @PostMapping("/register")
    public ResponseEntity registeredUser(@RequestBody RegistrationBody registrationBody) {
        try {
            userService.registeredUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

//        in the above method, we returned a type of ResponseEntity which allows you to edit the http responses to requests

    }

}
