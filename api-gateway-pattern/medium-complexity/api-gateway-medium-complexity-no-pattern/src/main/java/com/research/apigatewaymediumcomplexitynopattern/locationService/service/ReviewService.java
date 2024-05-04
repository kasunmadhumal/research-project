package com.research.apigatewaymediumcomplexitynopattern.locationService.service;


import com.research.apigatewaymediumcomplexitynopattern.authService.user.User;
import com.research.apigatewaymediumcomplexitynopattern.authService.user.UserRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Request.ReviewDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Location;
import com.research.apigatewaymediumcomplexitynopattern.locationService.entity.Review;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.ILocationRepository;
import com.research.apigatewaymediumcomplexitynopattern.locationService.repository.IReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record ReviewService(
        IReviewRepository reviewRepository,
        ILocationRepository locationRepository,
        UserRepository userRepository
) {

    public String saveReview(ReviewDto reviewDto) {

        Location location = locationRepository.findById(reviewDto.getLocationId()).orElseThrow();

        User user = userRepository.findByEmail(reviewDto.getUserEmail()).orElseThrow();

        Review review = Review.builder()
                .review(reviewDto.getReview())
                .rating(reviewDto.getRating())
                .location(location)
                .user(user)
                .build();

       // location.getReviews().add(review);
        try {
            reviewRepository.save(review);
            return "Review saved successfully";
        } catch (Exception e) {
            log.error("Error occurred while saving review", e);
        }
        return "Error occurred while saving review";
    }
}
