package ru.job4j.ood.srp.lsp.products;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk() {
    }

    public Milk(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }

    @Override
    public String toString() {
        return "Milk{"
                + "productId=" + productId
                + ", name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
