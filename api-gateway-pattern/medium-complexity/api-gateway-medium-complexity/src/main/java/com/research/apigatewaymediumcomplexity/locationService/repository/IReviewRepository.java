package com.research.apigatewaymediumcomplexity.locationService.repository;

import com.research.apigatewaymediumcomplexity.locationService.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {

    Set<Review> findAllByLocationId(Integer locationId);
}
