package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSpot assignedSpot;
    private LocalDateTime checkInTime;

}
