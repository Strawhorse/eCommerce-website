package com.jbr.eCommercesite.api.controller.auth;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {


//    method to register user so the return type is a boolean - just set it to void for now until we complete api
//    can test doing a POST request on Postman to http://localhost:8080/auth/register
//    payload below will be a RegistrationBody class and then set to Body -> raw -> json and send {} object with RegistrationBody parameters inside

    @PostMapping("/register")
    public void registeredUser(@RequestBody RegistrationBody registrationBody) {



        System.out.println(registrationBody.getUsername());

    }

}
