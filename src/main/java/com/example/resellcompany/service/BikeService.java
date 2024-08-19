package com.example.resellcompany.service;

import com.example.resellcompany.entity.Bike;
import com.example.resellcompany.entity.Book;
import com.example.resellcompany.pojo.BikePojo;
import com.example.resellcompany.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    List<Bike> getAllBikes();

    Bike createBikes(BikePojo bikePojo);

    Bike getBikesById(Integer id);

    Bike updateBike(Integer id, Bike bike);

    void deleteBike(Integer id);

}
