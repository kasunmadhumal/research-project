package com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Response;

import com.research.apigatewaymediumcomplexitynopattern.authService.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {

    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}
