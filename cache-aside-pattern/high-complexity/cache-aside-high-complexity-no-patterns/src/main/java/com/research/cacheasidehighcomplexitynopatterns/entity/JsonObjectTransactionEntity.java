package com.research.cacheasidehighcomplexitynopatterns.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
public class JsonObjectTransactionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String age;

    private String address;

    private String email;

    private String phone;

    private String school;

    private String company;

    private String university;

    private String college;

    private String department;

    private String designation;


    private String carType;

    private String carModel;

    private String carColor;

    private String carNumber;


    private String bikeType;


    private String bikeModel;


    private String bikeColor;


    private String bikeNumber;


    private String busType;

    public JsonObjectTransactionEntity(Long id, String name, String age, String address, String email, String phone, String school, String company, String university, String college, String department, String designation, String carType, String carModel, String carColor, String carNumber, String bikeType, String bikeModel, String bikeColor, String bikeNumber, String busType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.school = school;
        this.company = company;
        this.university = university;
        this.college = college;
        this.department = department;
        this.designation = designation;
        this.carType = carType;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carNumber = carNumber;
        this.bikeType = bikeType;
        this.bikeModel = bikeModel;
        this.bikeColor = bikeColor;
        this.bikeNumber = bikeNumber;
        this.busType = busType;
    }
}
