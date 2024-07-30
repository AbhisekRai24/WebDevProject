package com.example.resellcompany.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Bike_info")

public class Bike {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_setup_seq_gen")
    @SequenceGenerator(name = "parameter_setup_seq_gen", sequenceName = "parameters_setup_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="price")
    private String price;

    @Column(name="description")
    private String description;

    @Column(name="availability_status")
    private String availabilitystatus;
}
