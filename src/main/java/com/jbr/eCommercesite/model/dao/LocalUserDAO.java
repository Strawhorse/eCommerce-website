package com.jbr.eCommercesite.model.dao;

import com.jbr.eCommercesite.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//This is a DAO pattern; The Data Access Object is a structural pattern that isolates the application/business layer from the persistence layer
// (usually a relational database but could be any other persistence mechanism) using an abstract API.
// will create a CRUD repository for the Spring api -using LocalUser as the object and Long as the identifier

public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {

//    interface which can extend CrudRepository methods
//    2 new find functions added below

    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
