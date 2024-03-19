package com.jbr.eCommercesite.api.controller.auth;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


//    method to register user so the return type is a boolean - just set it to void for now until we complete api

    public void registeredUser() {
        System.out.println(Optional.ofNullable(null));
    }

}
