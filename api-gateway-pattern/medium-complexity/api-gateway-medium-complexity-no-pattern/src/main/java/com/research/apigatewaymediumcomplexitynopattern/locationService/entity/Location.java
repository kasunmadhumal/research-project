package com.research.apigatewaymediumcomplexitynopattern.locationService.entity;

import com.research.apigatewaymediumcomplexitynopattern.authService.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    private String locationName;
    private String description;
    private Double latitude;
    private Double longitude;
    private Double rating;
    private String averageAllocatedTime;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Event> events;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Preference> preferences;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<LocationImage> locationImages;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
