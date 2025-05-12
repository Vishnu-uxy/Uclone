package com.ride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.repository.RideRepository;

@Service
public class rideService {

	@Autowired
	private RideRepository repo;

	public void assign(int rideId, int driverId) {

	}
}
