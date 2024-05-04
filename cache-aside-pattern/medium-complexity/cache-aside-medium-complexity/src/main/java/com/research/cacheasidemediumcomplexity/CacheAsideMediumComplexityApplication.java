package com.research.cacheasidemediumcomplexity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAsideMediumComplexityApplication {
    public static void main(String[] args){
		SpringApplication.run(CacheAsideMediumComplexityApplication.class, args);
	}
}
