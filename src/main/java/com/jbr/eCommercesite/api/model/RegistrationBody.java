package com.jbr.eCommercesite.api.model;

public class RegistrationBody {

//    outline of data received from the front end to register a user (not including id, which is auto-generated)

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

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
