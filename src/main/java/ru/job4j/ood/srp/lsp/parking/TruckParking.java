package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.ArrayList;

public class TruckParking extends AbstractParking {


    public TruckParking(int spots) {
        parkingSpots = new ArrayList<>();
        super.spots = spots;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        return null;
    }
}
