package ru.job4j.ood.srp.lsp.products;

import java.time.LocalDate;

public class Sugar extends Food {
    public Sugar() {
    }

    public Sugar(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }

    @Override
    public String toString() {
        return "Sugar{"
                + "productId=" + productId
                + ", name='" + name + '\''
                + ", expiryDate=" + expiryDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
