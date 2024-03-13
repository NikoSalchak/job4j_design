package ru.job4j.serialization.json;

import java.io.Serializable;

public class Car {
    final private String brand;
    final private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", year=" + year
                + '}';
    }
}
