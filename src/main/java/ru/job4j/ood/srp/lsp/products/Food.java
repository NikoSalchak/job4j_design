package ru.job4j.ood.srp.lsp.products;

import java.time.LocalDate;
import java.util.Objects;

public class Food {
    protected int productId;
    protected String name;
    protected LocalDate expiryDate;
    protected LocalDate createDate;
    protected double price;
    protected double discount;

    protected Food() {
    }

    protected Food(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return productId == food.productId && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name);
    }
}
