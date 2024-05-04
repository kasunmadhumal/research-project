package com.research.apigatewaymediumcomplexity.locationService.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EventResponseDto {

    private Integer id;
    private String eventName;

}
