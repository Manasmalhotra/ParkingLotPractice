package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingSpot {
    private int floor;
    private int row;
    private int col;
    private VehicleType supportedVehicleType;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
