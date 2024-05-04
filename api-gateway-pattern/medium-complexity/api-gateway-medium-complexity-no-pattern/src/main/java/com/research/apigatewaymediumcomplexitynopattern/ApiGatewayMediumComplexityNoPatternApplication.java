package com.research.apigatewaymediumcomplexitynopattern;

import com.research.apigatewaymediumcomplexitynopattern.locationService.dto.Request.LocationDto;
import com.research.apigatewaymediumcomplexitynopattern.locationService.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiGatewayMediumComplexityNoPatternApplication {

	@Autowired
	private static LocationService locationService;

	ApiGatewayMediumComplexityNoPatternApplication(LocationService locationService) {
		ApiGatewayMediumComplexityNoPatternApplication.locationService = locationService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMediumComplexityNoPatternApplication.class, args);

		int m = 1000;
		for(int i = 0; i < m; i++) {
            int value = (int)(Math.random() * 1000);
			LocationDto locationDto = new LocationDto(
					"sri lanka" + value,
					"Uk is a country",
					2322.333,
					3232.232,
					"kasun@gmail.com",
					"1.30 hours",
					List.of("#Country", "#ColdCountry"),
					List.of("travelling", "shopping"),
					List.of("https://images.unsplash.com/photo-1543832923-44667a44c804?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8ZW5nbGFuZHxlbnwwfHwwfHx8MA%3D%3D", "https://t4.ftcdn.net/jpg/02/84/88/03/360_F_284880344_drcRa7TAow6riwp3pXdlJUlcmI5vvbbP.jpg", "https://images.pexels.com/photos/672532/pexels-photo-672532.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", "https://a.cdn-hotels.com/gdcs/production29/d1870/6a5ec560-bb25-11e8-970b-0242ac110006.jpg?impolicy=fcrop&w=800&h=533&q=medium")
			);

			ApiGatewayMediumComplexityNoPatternApplication.locationService.saveLocation(locationDto);
		}
	}

}
