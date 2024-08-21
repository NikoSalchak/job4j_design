package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.ArrayList;

public class TruckParking extends AbstractParking {

    public TruckParking(int spots) {
        parkingSpots = new ArrayList<>();
        super.spots = spots;
    }

    @Override
    public CarType getCarType() {
        return CarType.TRUCK;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        Vehicle rsl = null;
        if (vehicle.getCarType() == CarType.TRUCK && parkingSpots.size() != spots) {
            rsl = super.add(vehicle);
        }
        return rsl;
    }
}
