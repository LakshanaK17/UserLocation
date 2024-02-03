package com.example.userlocation.controller;

import com.example.userlocation.model.Location;
import com.example.userlocation.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    LocationService locationService;

//    private final SimpMessagingTemplate messagingTemplate;
//
//    public LocationWebSocketController(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }

    @PostMapping("/currentLocation")
    public ResponseEntity<String> createCurrentLocation(@RequestBody Location location) {
        try {
            locationService.saveLocation(location);
            return new ResponseEntity<>("Location saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/currentLocation/{userId}")
    public ResponseEntity<Object> getCurrentLocation(@PathVariable String userId) {
        try {
            Location location = locationService.getCurrentLocation(userId);
            if (location != null) {
                return new ResponseEntity<>(location, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No current location record found for the user", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving current location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/historicalLocations/{userId}")
    public ResponseEntity<Object> getHistoricalLocations(
            @PathVariable String userId,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit
    ) {
        try {
            List<Location> historicalLocations = locationService.getHistoricalLocations(userId, limit);
            if (!historicalLocations.isEmpty()) {
                return new ResponseEntity<>(historicalLocations, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No historical location records found for the user", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving historical locations", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @MessageMapping("/sendLocation")
//    public void sendLocation(@Payload Location location) {
//        messagingTemplate.convertAndSend("/topic/locationUpdates", location);
//    }

}
