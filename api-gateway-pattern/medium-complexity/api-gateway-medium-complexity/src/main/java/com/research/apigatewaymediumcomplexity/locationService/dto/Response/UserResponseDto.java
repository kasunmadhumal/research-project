package com.research.apigatewaymediumcomplexity.locationService.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {

    private String firstname;
    private String lastname;
    private String email;
}
