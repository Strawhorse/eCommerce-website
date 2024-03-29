package com.jbr.eCommercesite.api.controller.auth;


import com.jbr.eCommercesite.api.model.RegistrationBody;
import com.jbr.eCommercesite.exception.UserAlreadyExistsException;
import com.jbr.eCommercesite.service.UserService;
import jakarta.validation.Valid;
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






//    can test doing a POST request on Postman to http://localhost:8080/auth/register
//    payload below will be a RegistrationBody class and then set to Body -> raw -> json and send {} object with RegistrationBody parameters inside
//    then uses the userService object to register the user in the database


//    method below uses Spring @Valid annotation to validate data types used during this registration process
//    must be used at a controller level

    @PostMapping("/register")
    public ResponseEntity registeredUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registeredUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

//        in the above method, we returned a type of ResponseEntity which allows you to edit the http responses to requests

    }

}
