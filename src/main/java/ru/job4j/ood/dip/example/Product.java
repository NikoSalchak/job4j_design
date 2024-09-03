package ru.job4j.ood.dip.example;

import java.util.Objects;

public class Product {
    private String name;
    private double cost;
    private int productId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productId);
    }
}
