package com.research.apigatewaymediumcomplexitynopattern.locationService.service;

import com.research.apigatewaymediumcomplexitynopattern.authService.user.User;
import com.research.apigatewaymediumcomplexitynopattern.authService.user.UserRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Request.LocationDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Response.*;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Event;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.LocationImage;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Preference;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.ILocationImagesRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.ILocationRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.IPreferenceRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.IReviewRepository;
import jakarta.persistence.EntityNotFoundException;
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
        UserRepository userRepository,
        IReviewRepository reviewRepository,
        PreferencesService preferencesService,
        LocationImagesService locationImagesService,
        IPreferenceRepository preferenceRepository,
        ILocationImagesRepository locationImagesRepository,
        EventService eventService) {

    public String saveLocation(LocationDto locationDto) {


        User user = userRepository.findByEmail(locationDto.getUserEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + locationDto.getUserEmail()));

        try {
            Location locationCheck = iLocationRepository.findByLocationName(locationDto.getLocationName());
            if(locationCheck != null){
                return "Location Already in Database.";
            }
        }catch (EntityNotFoundException e){
            log.info("unique location");
        }

        var location = Location.builder()
                .locationName(locationDto.getLocationName())
                .description(locationDto.getDescription())
                .latitude(locationDto.getLatitude())
                .longitude(locationDto.getLongitude())
                .averageAllocatedTime(locationDto.getAverageAllocatedTime())
                .rating(0.0)
                .user(user)
                .build();

        try {
            Location savedLocation = iLocationRepository.saveAndFlush(location);
            if(savedLocation.getId() == null){
                return "Error occurred while saving location";
            }
            savedLocation.setPreferences(
                    locationDto.getPreferences().stream().map(preference -> Preference.builder()
                            .preference(preference)
                            .location(savedLocation)
                            .build()).collect(Collectors.toSet())
            );
            savedLocation.setLocationImages(
                    locationDto.getImages().stream().map(image -> LocationImage.builder()
                            .image(image)
                            .location(savedLocation)
                            .build()).collect(Collectors.toSet())
            );
            savedLocation.setEvents(
                    locationDto.getEvents().stream().map(event -> Event.builder()
                            .eventName(event)
                            .location(savedLocation)
                            .build()).collect(Collectors.toSet())
            );
            iLocationRepository.save(savedLocation);

        }catch (Exception e){
            log.error("Error occurred while saving location", e);
            return "Error occurred while saving location";
        }



        return "success";
    }

    public LocationResponseDto getLocation(Integer id) {

        log.info("LocationService: getLocation");
        Location location = iLocationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with ID: " + id));

        Set<ReviewResponseDto> reviewResponseDto = location.getReviews().stream().map(review -> ReviewResponseDto.builder()
                .review(review.getReview())
                .rating(review.getRating())
                .userEmail(review.getUser().getEmail())
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



        return LocationResponseDto.builder()
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
                        location.getUser().getFirstname(),
                        location.getUser().getLastname(),
                        location.getUser().getEmail(),
                        location.getUser().getRole()
                )).build();

    }


    public List<LocationResponseDto> getAllLocations() {

        List<Location> locations = iLocationRepository.findAll();
        List<LocationResponseDto> responseDtos = new ArrayList<>();
        for(Location location: locations){

            Set<ReviewResponseDto> reviewResponseDto = location.getReviews().stream().map(review -> ReviewResponseDto.builder()
                    .review(review.getReview())
                    .rating(review.getRating())
                    .userEmail(review.getUser().getEmail())
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
                            location.getUser().getFirstname(),
                            location.getUser().getLastname(),
                            location.getUser().getEmail(),
                            location.getUser().getRole()
                    )).build();

            responseDtos.add(locationResponseDto);

        }

        return responseDtos;
    }
}
