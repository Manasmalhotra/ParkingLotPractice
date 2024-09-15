package org.example.service.impl;

import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.models.Vehicle;
import org.example.service.SpotAllocationStrategy;

import java.time.LocalDateTime;

public class RandomSpotAllocationImpl implements SpotAllocationStrategy {
    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, Vehicle vehicle,LocalDateTime checkInTime) {
        for(ParkingSpot spot:parkingLot.getParkingSpotList()){
            if(spot.getCheckIn()==null || (spot.getCheckOut()!=null && spot.getCheckOut().isBefore(checkInTime)) &&
               spot.getSupportedVehicleType().equals(vehicle.getVehicleType())){
                spot.setCheckIn(checkInTime);
                spot.setCheckOut(null);
                return spot;
            }
        }
        return null;
    }
}
