package com.research.apigatewaymediumcomplexity.locationService.service;


import com.research.apigatewaymediumcomplexity.locationService.entity.Location;
import com.research.apigatewaymediumcomplexity.locationService.repository.IEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record EventService(IEventRepository eventRepository) {

    public void addEvent(List<String> eventList, Location savedLocation){

    }
}
