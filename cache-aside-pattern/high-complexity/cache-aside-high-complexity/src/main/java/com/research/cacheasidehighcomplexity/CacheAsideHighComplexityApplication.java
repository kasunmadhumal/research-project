package com.research.cacheasidehighcomplexity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAsideHighComplexityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheAsideHighComplexityApplication.class, args);
	}

}
