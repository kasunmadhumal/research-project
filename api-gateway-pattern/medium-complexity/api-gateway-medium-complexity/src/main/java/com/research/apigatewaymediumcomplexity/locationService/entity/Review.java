package com.research.apigatewaymediumcomplexity.locationService.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    private Integer id;
    private String review;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;




}
