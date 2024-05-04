package com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReviewResponseDto {

    private String review;
    private Integer rating;
    private String userEmail;
}
