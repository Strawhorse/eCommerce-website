//JPA stands for Java Persistence API.
// It is an object-relational mapping (ORM) framework that allows us to map Java objects to tables in a relational database.
//Entities in JPA are nothing but POJOs representing data that can be persisted in the database



package com.jbr.eCommercesite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "local_user")
public class LocalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}