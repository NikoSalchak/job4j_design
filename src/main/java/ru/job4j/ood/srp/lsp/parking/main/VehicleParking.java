package ru.job4j.ood.srp.lsp.parking.main;

import ru.job4j.ood.srp.lsp.parking.Parking;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.List;

public class VehicleParking {
    private List<Parking> parking;

    public VehicleParking(List<Parking> parking) {
        this.parking = parking;
    }

    public void putTheCar(Vehicle vehicle) {
    }

    public Vehicle findByParkingId(int parkingId) {
        return null;
    }
}
