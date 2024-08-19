package com.example.resellcompany.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class BookPojo {
    private Integer id;
    private LocalDateTime bookingDateTime;
    private boolean status;
    private Integer userId;       // ID of the user making the booking
    private Integer bikeId;


}
