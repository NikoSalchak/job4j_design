package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.ArrayList;

public class CarParking extends AbstractParking {

    public CarParking(int spots) {
        parkingSpots = new ArrayList<>();
        super.spots = spots;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        return super.add(vehicle);
    }
}
