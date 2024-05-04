package com.research.apigatewaymediumcomplexitynopattern.locationService.controller;

import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Request.LocationDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Request.ReviewDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Response.LocationResponseDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.service.LocationService;
import com.research.apigatewaymediumcomplexitynopattern.locationService.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@Slf4j
public class LocationController {

    private final LocationService locationService;
    private final ReviewService reviewService;

    public LocationController(LocationService locationService, ReviewService reviewService) {
        this.locationService = locationService;
        this.reviewService = reviewService;
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('PREMIUM_USER')")
    @PostMapping("/save")
    public String saveLocation(@RequestBody LocationDto locationDto) {
        log.info("LocationController: saveLocation");
        return locationService.saveLocation(locationDto);
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('PREMIUM_USER')")
    @GetMapping("/{id}")
    public LocationResponseDto getLocation(@PathVariable Integer id) {
        log.info("LocationController: getLocation");
        return locationService.getLocation(id);
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN') or hasRole('PREMIUM_USER')")
    @GetMapping("/")
    public List<LocationResponseDto> getAllLocations() {
        log.info("LocationController: getAllLocations");
        return locationService.getAllLocations();
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') and hasRole('ROLE_ADMIN') or hasRole('PREMIUM_USER')")
    @PostMapping("/review")
    public String saveReview(@RequestBody ReviewDto reviewDto) {
        log.info("LocationController: saveReview");
        return reviewService.saveReview(reviewDto);
    }




}
