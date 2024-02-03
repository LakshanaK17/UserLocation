package com.example.userlocation.repository;

import com.example.userlocation.model.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

    Location findByUserId(String userId);

    List<Location> findHistoricalLocations(String userId, int limit);

}
