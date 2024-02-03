package com.example.userlocation.service;

import com.example.userlocation.model.Location;
import com.example.userlocation.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }


    public Location getCurrentLocation(String userId) {
        return locationRepository.findByUserId(userId);
    }


    public List<Location> getHistoricalLocations(String userId, int limit) {
        // Implement logic to retrieve historical locations for the given user ID with a limit
        // You might want to handle the case when no historical location records are found for the user
        return locationRepository.findHistoricalLocations(userId, limit);
    }

}
