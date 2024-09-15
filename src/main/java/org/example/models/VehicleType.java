package org.example.models;

import lombok.Getter;

@Getter
public enum VehicleType {
    CAR(2,40),
    BIKE(3,30),
    TRUCK(1,50);

    private int floor;
    private double fare;
    VehicleType(int floor,double fare) {
        this.floor = floor;
        this.fare = fare;
    }
}
