package com.research.apigatewaymediumcomplexitynopattern.locationService.service;


import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.IPreferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record PreferencesService (IPreferenceRepository preferenceRepository){

    public void addLocationPreferences(List<String> preferencesList, Location savedLocation){

    }
}
