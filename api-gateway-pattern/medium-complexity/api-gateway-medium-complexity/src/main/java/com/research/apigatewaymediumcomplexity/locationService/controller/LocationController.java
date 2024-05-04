package com.research.apigatewaymediumcomplexity.locationService.controller;


import com.research.apigatewaymediumcomplexity.locationService.dto.Request.LocationDto;
import com.research.apigatewaymediumcomplexity.locationService.dto.Request.ReviewDto;
import com.research.apigatewaymediumcomplexity.locationService.dto.Response.LocationResponseDto;
import com.research.apigatewaymediumcomplexity.locationService.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@Slf4j
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/")
    public List<LocationResponseDto> getAllLocations() {
        log.info("LocationController: getAllLocations");
        return locationService.getAllLocations();
    }




}
