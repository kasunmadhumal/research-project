package com.research.apigatewaymediumcomplexitynopattern.locationService.service;


import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.IEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record EventService(IEventRepository eventRepository) {

    public void addEvent(List<String> eventList, Location savedLocation){

    }
}
