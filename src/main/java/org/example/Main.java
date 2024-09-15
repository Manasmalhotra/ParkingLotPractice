package org.example;

import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.models.VehicleType;
import org.example.service.FareCalculationStrategy;
import org.example.service.SpotAllocationStrategy;
import org.example.service.impl.BasicFareCalculation;
import org.example.service.impl.RandomSpotAllocationImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;

    private static List<ParkingSpot> getSpots(long numberOfSpots, VehicleType vehicleType) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 1; i <= numberOfSpots; i++) {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.setSupportedVehicleType(vehicleType);
            parkingSpot.setFloor(1);
            parkingSpot.setRow(i / 10);
            parkingSpot.setCol(i % 10);
            parkingSpots.add(parkingSpot);
        }
        return parkingSpots;
    }

    private static ParkingLot initializeLot(long truckSpots, long carSpots, long bikeSpots) {
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.addAll(getSpots(truckSpots, VehicleType.TRUCK));
        parkingSpots.addAll(getSpots(carSpots, VehicleType.CAR));
        parkingSpots.addAll(getSpots(bikeSpots, VehicleType.BIKE));
        parkingLot.setParkingSpotList(parkingSpots);
        return parkingLot;
    }

    private static Ticket generateTicket(ParkingLot parkingLot,Vehicle vehicle) {
           SpotAllocationStrategy spotAllocationStrategy=new RandomSpotAllocationImpl();
           Ticket ticket = new Ticket();
           ticket.setId(UUID.randomUUID().toString());
           ticket.setCheckInTime(LocalDateTime.now());
           ticket.setVehicle(vehicle);
           ticket.setAssignedSpot(spotAllocationStrategy.assignSpot(parkingLot,vehicle,ticket.getCheckInTime()));
           return ticket;
    }

    private static double fareCalculation(Ticket ticket){
        FareCalculationStrategy fareCalculationStrategy = new BasicFareCalculation();
        return fareCalculationStrategy.calculateFare(ticket);
    }

    public static void main(String[] args) {
        System.out.println("WELCOME TO PARKING LOT!");
        ParkingLot parkingLot = initializeLot(20, 200, 50);
        Vehicle vehicle = new Vehicle("UP-AN-123", VehicleType.CAR);
        Ticket ticket = generateTicket(parkingLot,vehicle);
        double billAmount=fareCalculation(ticket);
        System.out.println("Fare: "+billAmount);
    }
}