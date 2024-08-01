package ru.job4j.ood.srp;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private long money;
    private List<Product> products;

    public Customer() {
    }

    public Customer(String name, long money) {
        this.name = name;
        this.money = money;
    }

    public Customer(String name, long money, List<Product> products) {
        this.name = name;
        this.money = money;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + ", money=" + money
                + ", products=" + products
                + '}';
    }
}
