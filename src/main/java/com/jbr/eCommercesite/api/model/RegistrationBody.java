package com.jbr.eCommercesite.api.model;

import jakarta.validation.constraints.*;

public class RegistrationBody {

//    outline of data received from the front end to register a user (not including id, which is auto-generated)

    @NotNull
    @NotBlank
    @Size(min = 3, max = 120)
    private String username;

    @NotNull
    @NotBlank
    @Email
    @Size(min = 3, max = 320)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 1000)
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 120)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 120)
    private String lastName;

    public RegistrationBody() {
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
