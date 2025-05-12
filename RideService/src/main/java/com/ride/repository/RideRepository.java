package com.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.model.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride,Long> {

}
