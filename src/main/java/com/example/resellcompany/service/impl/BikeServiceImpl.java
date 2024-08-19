package com.example.resellcompany.service.impl;

import com.example.resellcompany.entity.Bike;
import com.example.resellcompany.entity.User;
import com.example.resellcompany.pojo.BikePojo;
import com.example.resellcompany.repository.BikeRepository;
import com.example.resellcompany.repository.UserRepository;
import com.example.resellcompany.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class BikeServiceImpl implements BikeService {
    private final BikeRepository bikeRepository;



    @Override
    public List<Bike> getAllBikes() {
        return  bikeRepository.findAll();
    }

    @Override
    public Bike createBikes(BikePojo bikePojo) {
        Bike bike= new Bike();

        bike.setId(bikePojo.getId());
        bike.setBrand(bikePojo.getBrand());
        bike.setModel(bikePojo.getModel());
        bike.setPrice(bikePojo.getPrice());
        bike.setDescription(bikePojo.getDescription());
        bike.setAvailability_status(bikePojo.getAvailability_status());

        return bikeRepository.save(bike);

    }

    @Override
    public Bike getBikesById(Integer id) {
        return bikeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    @Override
    public Bike updateBike(Integer id, Bike bike) {
        Bike existingBike = bikeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));


        existingBike.setBrand(bike.getBrand());
        existingBike.setModel(bike.getModel());
        existingBike.setPrice(bike.getPrice());
        existingBike.setDescription(bike.getDescription());
        existingBike.setAvailability_status(bike.getAvailability_status());

        return bikeRepository.save(existingBike);
    }

    @Override
    public void deleteBike(Integer id) {
        bikeRepository.deleteById(id);

    }
}
