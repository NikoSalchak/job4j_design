package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Car {
    @XmlAttribute
    private String brand;
    @XmlAttribute
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", year=" + year
                + '}';
    }
}
