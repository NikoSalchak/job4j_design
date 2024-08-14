package ru.job4j.ood.srp.lsp.products;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread() {
    }

    public Bread(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }

    @Override
    public String toString() {
        return "Bread{"
                + "productId=" + productId
                + ", name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
