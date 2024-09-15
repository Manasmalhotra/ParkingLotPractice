package org.example.service.impl;

import org.example.models.Ticket;
import org.example.service.FareCalculationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class BasicFareCalculation implements FareCalculationStrategy {
    @Override
    public double calculateFare(Ticket parkingTicket) {
        LocalDateTime checkIn=parkingTicket.getCheckInTime();
        Duration duration=Duration.between(checkIn,LocalDateTime.now());
        return parkingTicket.getVehicle().getVehicleType().getFare()*duration.toMinutes();
    }
}
