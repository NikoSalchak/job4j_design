package ru.job4j.ood.srp.lsp.parking;

import ru.job4j.ood.srp.lsp.parking.vehicles.CarType;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.List;

public interface Parking {

    Vehicle add(Vehicle vehicle);

    boolean replace(int parkingId, Vehicle vehicle);

    Vehicle getVehicle(int parkingId);

    List<Vehicle> findAll();

    List<Vehicle> findByName(String name);

    List<Vehicle> findByCarType(CarType carType);

}
