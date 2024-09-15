package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot {
    private List<ParkingSpot> parkingSpotList;
}
