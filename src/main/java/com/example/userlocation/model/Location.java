package com.example.userlocation.model;

import org.springframework.stereotype.Component;

@Component
public class Location {

    private String locationid;
    private String userId;
    private double latitude;
    private double longitude;
    private long timestamp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }
}
