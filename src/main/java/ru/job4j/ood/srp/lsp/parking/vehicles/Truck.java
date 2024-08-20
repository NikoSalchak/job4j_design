package ru.job4j.ood.srp.lsp.parking.vehicles;

public class Truck extends Vehicle {

    public Truck() {
    }

    public Truck(String name, int parkingId) {
        super(name, 2, CarType.TRUCK, parkingId);
    }

    @Override
    public String toString() {
        return "Truck{"
                + "name='" + name + '\''
                + ", size=" + size
                + ", carType=" + carType
                + ", parkingId=" + parkingId
                + '}';
    }
}
