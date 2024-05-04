package com.research.apigatewaymediumcomplexitynopattern.locationService.repository;

import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {


}
