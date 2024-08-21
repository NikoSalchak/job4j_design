package ru.job4j.ood.srp.lsp.parking.main;

import ru.job4j.ood.srp.lsp.parking.Parking;
import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.List;

public class VehicleParking {
    private List<Parking> parking;

    boolean truckParkingFull = false;

    public VehicleParking(List<Parking> parking) {
        this.parking = parking;
    }

    public void putTheCar(Vehicle vehicle) {
        for (Parking p : parking) {
            if (p.getCarType() == CarType.TRUCK && vehicle.getCarType() == CarType.TRUCK && p.getSizeParking() < p.getSpots()) {
                p.add(vehicle);
                if (p.getSizeParking() == p.getSpots()) {
                    truckParkingFull = true;
                }
            } else if (p.getCarType() == CarType.CAR && vehicle.getCarType() == CarType.CAR || vehicle.getCarType() == CarType.TRUCK && parking.size() == 1) {
                p.add(vehicle);
            } else if (truckParkingFull && vehicle.getCarType() == CarType.TRUCK) {
                p.add(vehicle);
            }
        }
    }

    public Vehicle findByParkingId(int parkingId) {
        Vehicle rsl = null;
        for (Parking p : parking) {
            rsl = p.getVehicle(parkingId);
            if (rsl != null) {
                break;
            }
        }
        return rsl;
    }
}
