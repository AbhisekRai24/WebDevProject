package com.example.resellcompany.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Login")

public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_setup_seq_gen")
    @SequenceGenerator(name = "parameter_setup_seq_gen", sequenceName = "parameters_setup_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "user")
    private Set<Book> books;


}
