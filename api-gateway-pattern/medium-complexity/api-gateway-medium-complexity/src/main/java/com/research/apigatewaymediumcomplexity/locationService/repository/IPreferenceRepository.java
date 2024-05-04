package com.research.apigatewaymediumcomplexity.locationService.repository;

import com.research.apigatewaymediumcomplexity.locationService.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPreferenceRepository extends JpaRepository<Preference, Integer> {

    Set<Preference> findAllByLocationId(Integer locationId);
}
