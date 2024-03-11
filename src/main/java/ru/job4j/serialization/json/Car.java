package ru.job4j.serialization.json;

import java.io.Serializable;

public class Car implements Serializable {
    final private String brand;
    final private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", year=" + year
                + '}';
    }
}
