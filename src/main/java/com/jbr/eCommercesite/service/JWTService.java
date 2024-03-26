package com.jbr.eCommercesite.service;


//JSON web token - encrypted string to pass as credential identifier
//Send login info, and when received we send an encrypted that they will hold (not a cookie; cookieless authentication, cookies are prone to CSRF) and use when they make requests
// The user logs into the service by providing their login credentials.
// It issues an access request from the client-side by sending the credential and API key (public key) to the application server.
// The server verifies the login credentials that checks the password entered against the username.
// Once approved, the server will generate a unique session token that will help authorize subsequent actions.
// This access token is sent back to the client via URL query strings, post request body, or other means.
// The server-generated signed authentication token gets assigned with an expiration time.
// The token gets transmitted back to the user's browser.
// On every subsequent request to the application server, the access token gets added to the authorization header along with the public key.


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jbr.eCommercesite.model.LocalUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;



public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;


//    showing that I was the person giving them the JWT

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

//    Algorithm from the JWT library

    private Algorithm algorithm;

    private static final String USERNAME_KEY = "USERNAME";


    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {

        algorithm = HMAC256(algorithmKey);

    }


//Now generate the JWT

    public String generateJWT(LocalUser user){

//        withClaim() method is almost like a key-object hash mapper
//        Will encrypt a string that expires in an amount of time
//        Have USERNAME embedded into it
//        sign with encryption algo


        return JWT.create().withClaim(USERNAME_KEY, user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);

    }


}
