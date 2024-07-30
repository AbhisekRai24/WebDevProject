package com.example.resellcompany.service.impl;

import com.example.resellcompany.entity.Bike;
import com.example.resellcompany.repository.BikeRepository;
import com.example.resellcompany.repository.UserRepository;
import com.example.resellcompany.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class BikeServiceImpl implements BikeService {
    private final BikeRepository bikeRepository;


    @Override
    public List getAll() {
        return (List) bikeRepository.findAll();
    }
}
