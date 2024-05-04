package com.research.cacheasidesimplecomplexity;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAsideSimpleComplexityApplication {


	public static void main(String[] args) {
		SpringApplication.run(CacheAsideSimpleComplexityApplication.class, args);

	}



}
