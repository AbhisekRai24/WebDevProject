package com.example.resellcompany.pojo;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BikePojo {
    private Integer id;
    private String brand;
    private String model;
    private String price;
    private String description;
    private String availability_status;

}
