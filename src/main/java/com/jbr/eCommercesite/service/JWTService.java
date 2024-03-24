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


import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;

public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;

    private Algorithm algorithm;


    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {

        algorithm = HMAC256(algorithmKey);

    }


}
