package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.ArrayList;
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
        parkingSpots.add(vehicle);
        return vehicle;
    }

    protected int indexOf(int parkingId) {
        int rsl = -1;
        for (int i = 0; i < parkingSpots.size(); i++) {
            if (parkingSpots.get(i).getParkingId() == parkingId) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(int parkingId, Vehicle vehicle) {
        int index = indexOf(parkingId);
        boolean rsl = index != -1;
        if (rsl) {
            parkingSpots.set(index, vehicle);
        }
        return rsl;
    }

    @Override
    public Vehicle getVehicle(int parkingId) {
        int index = indexOf(parkingId);
        return index != -1 ? parkingSpots.get(index) : null;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.copyOf(parkingSpots);
    }

    @Override
    public List<Vehicle> findByName(String name) {
        List<Vehicle> rsl = new ArrayList<>();
        for (Vehicle vehicle : parkingSpots) {
            if (vehicle.getName().equals(name)) {
                rsl.add(vehicle);
            }
        }
        return rsl;
    }

    @Override
    public List<Vehicle> findByCarType(CarType carType) {
        List<Vehicle> rsl = new ArrayList<>();
        for (Vehicle vehicle : parkingSpots) {
            if (vehicle.getCarType() == carType) {
                rsl.add(vehicle);
            }
        }
        return rsl;
    }
}
