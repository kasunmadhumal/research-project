package com.research.apigatewaymediumcomplexitynopattern.locationService.service;

import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.ILocationImagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record LocationImagesService(ILocationImagesRepository locationImagesRepository) {

    public void addLocationImages(List<String> images, Location location) {

    }


}
