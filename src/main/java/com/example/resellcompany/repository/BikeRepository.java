package com.example.resellcompany.repository;

import com.example.resellcompany.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BikeRepository extends JpaRepository<Bike, Integer> {
}
