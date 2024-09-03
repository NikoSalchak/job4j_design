package ru.job4j.ood.dip.example;

import java.util.Objects;

public class Purchaser {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Purchaser purchaser = (Purchaser) o;
        return id == purchaser.id && Objects.equals(name, purchaser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
