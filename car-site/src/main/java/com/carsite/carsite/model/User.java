package com.carsite.carsite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User {

    private static final long serialVersionUID = 1L;

    public User(){

    }

    public User(
            String id,
            String username,
            String passwordHash,
            String email,
            Address address,
            boolean isAdmin
    ) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    @Id
    @Column(columnDefinition = "VARCHAR(512)", unique = true)
    @NotNull
    private String id;

    private String username;

    @Column(name = "password_hash")
    private String passwordHash;


    @OneToOne
    @JoinColumn(name = "address_id", columnDefinition = "VARCHAR(512)")
    @NotNull
    private Address address;

    private String email;

    @Column(name = "is_admin", columnDefinition = "boolean")
    private Boolean isAdmin;

}
