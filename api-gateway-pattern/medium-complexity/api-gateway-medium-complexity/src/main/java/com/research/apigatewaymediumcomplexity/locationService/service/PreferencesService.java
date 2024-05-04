package com.research.apigatewaymediumcomplexity.locationService.service;

import com.research.apigatewaymediumcomplexity.locationService.entity.Location;
import com.research.apigatewaymediumcomplexity.locationService.repository.IPreferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record PreferencesService (IPreferenceRepository preferenceRepository){

    public void addLocationPreferences(List<String> preferencesList, Location savedLocation){

    }
}
