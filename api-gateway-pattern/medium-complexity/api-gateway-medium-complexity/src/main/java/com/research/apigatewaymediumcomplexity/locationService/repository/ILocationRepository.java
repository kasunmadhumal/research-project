package com.research.apigatewaymediumcomplexity.locationService.repository;


import com.research.apigatewaymediumcomplexity.locationService.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {
    Location findByLocationName(String name);
}
