package com.subha.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subha.location.entities.Location;
import com.subha.location.repos.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationRepository repository;
	
	public Location saveLocation(Location location) {
		return repository.save(location);
	}
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	public List<Location> getAllLocation() {
		return repository.findAll();
	}
	
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

}
