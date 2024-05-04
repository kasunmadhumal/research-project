package com.research.apigatewaymediumcomplexity.locationService.service;


import com.research.apigatewaymediumcomplexity.locationService.dto.Response.*;
import com.research.apigatewaymediumcomplexity.locationService.entity.Location;
import com.research.apigatewaymediumcomplexity.locationService.repository.ILocationImagesRepository;
import com.research.apigatewaymediumcomplexity.locationService.repository.ILocationRepository;
import com.research.apigatewaymediumcomplexity.locationService.repository.IPreferenceRepository;
import com.research.apigatewaymediumcomplexity.locationService.repository.IReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
@Service
public record LocationService(
        ILocationRepository iLocationRepository,
        IReviewRepository reviewRepository,
        PreferencesService preferencesService,
        LocationImagesService locationImagesService,
        IPreferenceRepository preferenceRepository,
        ILocationImagesRepository locationImagesRepository,
        EventService eventService) {


    public List<LocationResponseDto> getAllLocations() {

        List<Location> locations = iLocationRepository.findAll();
        List<LocationResponseDto> responseDtos = new ArrayList<>();
        for(Location location: locations){

            Set<ReviewResponseDto> reviewResponseDto = location.getReviews().stream().map(review -> ReviewResponseDto.builder()
                    .review(review.getReview())
                    .rating(review.getRating())
                    .userEmail("kasun@gmail.com")
                    .build()).collect(Collectors.toSet());
            Set<PreferencesResponseDto> preferencesResponseDto = location.getPreferences().stream().map(preference -> PreferencesResponseDto.builder()
                    .id(preference.getId())
                    .preference(preference.getPreference())
                    .build()).collect(Collectors.toSet());

            Set<LocationImageResponseDto> locationImageResponseDto = location.getLocationImages().stream().map(locationImage -> LocationImageResponseDto.builder()
                    .id(locationImage.getId())
                    .image(locationImage.getImage())
                    .build()).collect(Collectors.toSet());

            Set<EventResponseDto> eventResponseDto = location.getEvents().stream().map(event -> EventResponseDto.builder()
                    .id(event.getId())
                    .eventName(event.getEventName())
                    .build()).collect(Collectors.toSet());

            LocationResponseDto locationResponseDto = LocationResponseDto.builder()
                    .id(location.getId())
                    .locationName(location.getLocationName())
                    .description(location.getDescription())
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude())
                    .reviews(reviewResponseDto)
                    .events(eventResponseDto)
                    .preferences(preferencesResponseDto)
                    .locationImages(locationImageResponseDto)
                    .userResponseDto(new UserResponseDto(
                            "kasun",
                             "madhumal",
                            "kasun@gmail.com"
                    )).build();

            responseDtos.add(locationResponseDto);

        }

        return responseDtos;
    }
}
