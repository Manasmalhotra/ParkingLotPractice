package org.example.service;

import org.example.models.Ticket;

public interface FareCalculationStrategy {
    double calculateFare(Ticket parkingTicket);
}
