package com.research.apigatewaymediumcomplexity.locationService.repository;

import com.research.apigatewaymediumcomplexity.locationService.entity.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ILocationImagesRepository extends JpaRepository<LocationImage, Long> {

    Set<LocationImage> findAllByLocationId(Integer locationId);
}
