package ru.job4j.generics;

import java.util.Objects;

public class Animal {
    String name;
    boolean sharpTeeth;
    float weight;

    public Animal(String name, boolean sharpTeeth, float weight) {
        this.name = name;
        this.sharpTeeth = sharpTeeth;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isSharpTeeth() {
        return sharpTeeth;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return sharpTeeth == animal.sharpTeeth
                && Float.compare(animal.weight, weight) == 0
                && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sharpTeeth, weight);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", sharpTeeth=" + sharpTeeth
                + ", weight=" + weight
                + '}';
    }
}
