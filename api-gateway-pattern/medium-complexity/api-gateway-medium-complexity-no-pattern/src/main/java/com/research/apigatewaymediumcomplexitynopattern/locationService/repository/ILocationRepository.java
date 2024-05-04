package com.research.apigatewaymediumcomplexitynopattern.locationService.repository;

import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {
    Location findByLocationName(String name);
}
