package com.subha.location.service;

import java.util.List;

import com.subha.location.entities.Location;

public interface LocationService {

	
	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	Location getLocationById(int id);
	
	List<Location> getAllLocation();
	
	void deleteLocation(Location location);
}
