package ru.job4j.ood.srp.lsp.parking.main;

import ru.job4j.ood.srp.lsp.parking.CarParking;
import ru.job4j.ood.srp.lsp.parking.Parking;
import ru.job4j.ood.srp.lsp.parking.TruckParking;
import ru.job4j.ood.srp.lsp.parking.vehicles.Car;
import ru.job4j.ood.srp.lsp.parking.vehicles.Truck;
import ru.job4j.ood.srp.lsp.parking.vehicles.Vehicle;

import java.util.Arrays;
import java.util.List;

public class VehicleParking {
    private List<Parking> parking;

    public VehicleParking(List<Parking> parking) {
        this.parking = parking;
    }

    public void putTheCar(Vehicle vehicle) {
        for (Parking p : parking) {
                p.add(vehicle);
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

    public static void main(String[] args) {
        List<Parking> spots = Arrays.asList(
                new CarParking(6),
                new TruckParking(3)
        );
        Vehicle vaz = new Car("vaz", 1);
        Vehicle lada = new Car("lada", 2);
        Vehicle toyota = new Car("toyota", 3);
        Vehicle toyota2 = new Car("toyota2", 4);
        Vehicle kamaz = new Truck("kamaz", 5);
        Vehicle cruz = new Truck("cruz", 6);
        Vehicle ural = new Truck("ural", 7);
        Vehicle gaz = new Truck("gaz", 8);
        VehicleParking parking = new VehicleParking(spots);
        parking.putTheCar(vaz);
        parking.putTheCar(lada);
        parking.putTheCar(toyota);
        parking.putTheCar(toyota2);
        parking.putTheCar(kamaz);
        parking.putTheCar(cruz);
        parking.putTheCar(ural);
        parking.putTheCar(gaz);
        System.out.println(spots.get(0).findAll());
        System.out.println(spots.get(0).findAll().size());
        System.out.println();
        System.out.println(spots.get(1).findAll());
        System.out.println();
        System.out.println(parking.findByParkingId(5));
    }
}
