package com.example.resellcompany.repository;

import com.example.resellcompany.entity.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, Integer> {
}
