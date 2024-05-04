package com.research.apigatewaymediumcomplexity.locationService.service;

import com.research.apigatewaymediumcomplexity.locationService.entity.Location;
import com.research.apigatewaymediumcomplexity.locationService.repository.ILocationImagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record LocationImagesService(ILocationImagesRepository locationImagesRepository) {

    public void addLocationImages(List<String> images, Location location) {

    }


}
