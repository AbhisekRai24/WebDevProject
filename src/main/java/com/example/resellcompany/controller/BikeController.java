package com.example.resellcompany.controller;


import com.example.resellcompany.entity.Bike;
import com.example.resellcompany.pojo.BikePojo;
import com.example.resellcompany.service.BikeService;
import com.example.resellcompany.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;
    @GetMapping("/getAll")
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("/{id}")
    public Bike getBikeById(@PathVariable Integer id) {
        return bikeService.getBikesById(id);
    }

    @PostMapping("/bikecreate")
    public ResponseEntity<Bike> createBikes(@RequestBody BikePojo bikePojo) {
        Bike bike = bikeService.createBikes(bikePojo);
        return new ResponseEntity<>(bike, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public Bike updateBike(@PathVariable Integer id, @RequestBody Bike bike) {
        return bikeService.updateBike(id, bike);
    }

    @DeleteMapping("remove/{id}")
    public void deleteBike(@PathVariable Integer id) {
        bikeService.deleteBike(id);
    }
}

