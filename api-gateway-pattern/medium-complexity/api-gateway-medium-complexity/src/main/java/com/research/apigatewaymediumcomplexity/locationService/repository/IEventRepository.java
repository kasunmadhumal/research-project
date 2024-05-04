package com.research.apigatewaymediumcomplexity.locationService.repository;


import com.research.apigatewaymediumcomplexity.locationService.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {


}
