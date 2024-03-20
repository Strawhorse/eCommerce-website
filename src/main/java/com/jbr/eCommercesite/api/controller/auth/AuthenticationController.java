package com.jbr.eCommercesite.api.controller.auth;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.service.UserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public void registeredUser(@RequestBody RegistrationBody registrationBody) {
        userService.registeredUser(registrationBody);

        System.out.println("... and it worked...");

    }

}
