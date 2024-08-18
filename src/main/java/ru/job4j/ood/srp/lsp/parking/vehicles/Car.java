package ru.job4j.ood.srp.lsp.parking.vehicles;

public class Car extends Vehicle {

    public Car() {
    }

    public Car(String name, int parkingId) {
        super(name, 1, CarType.CAR, parkingId);
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", size=" + size
                + ", carType='" + carType + '\''
                + '}';
    }
}
