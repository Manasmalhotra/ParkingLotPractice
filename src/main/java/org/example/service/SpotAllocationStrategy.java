package org.example.service;

import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.models.Vehicle;

import java.time.LocalDateTime;

public interface SpotAllocationStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, Vehicle vehicle, LocalDateTime checkInTime);
}
