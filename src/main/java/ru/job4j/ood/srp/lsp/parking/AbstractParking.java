package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.List;

public class AbstractParking implements Parking {
    protected List<Vehicle> parkingSpots;
    protected int spots;

    public AbstractParking() {
    }

    public AbstractParking(List<Vehicle> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        return null;
    }

    @Override
    public boolean replace(int parkingId, Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle getVehicle(int parkingId) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }

    @Override
    public List<Vehicle> findByName(String name) {
        return null;
    }

    @Override
    public List<Vehicle> findByCarType(CarType carType) {
        return null;
    }
}
