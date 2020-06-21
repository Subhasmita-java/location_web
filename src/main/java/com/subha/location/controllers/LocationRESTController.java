package com.subha.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subha.location.entities.Location;
import com.subha.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
	@Autowired
	LocationRepository locationRepo;
	
	@GetMapping
	public List<Location> getAllLocation(){
		return locationRepo.findAll();
	}
	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	} 
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepo.save(location);
	}
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepo.deleteById(id);;
	}
	@GetMapping("/{id}")
	public Location getOneLocation(@PathVariable("id") int id) {
		return locationRepo.findById(id).get();
	}
	
}
