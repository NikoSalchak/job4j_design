package ru.job4j.ood.srp.lsp.parking.vehicles;

import java.util.Objects;

public abstract class Vehicle {
    protected String name;
    protected int size;
    protected CarType carType;
    protected int parkingId;

    public Vehicle() {
    }

    public Vehicle(String name, int size, CarType carType, int parkingId) {
        this.name = name;
        this.size = size;
        this.carType = carType;
        this.parkingId = parkingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return size == vehicle.size
                && Objects.equals(name, vehicle.name)
                && Objects.equals(carType, vehicle.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, carType);
    }
}
