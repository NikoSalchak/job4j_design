package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.ArrayList;

public class CarParking extends AbstractParking {
    private int occupancy = 0;

    public CarParking(int spots) {
        parkingSpots = new ArrayList<>();
        super.spots = spots;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        Vehicle rsl = null;
        if (occupancy < spots) {
            rsl = super.add(vehicle);
            occupancy += vehicle.getSize();
        }
        return rsl;
    }
}
