package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String name;
    private double money;
    private ArrayList<Shoes> purchases;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Shoes> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Shoes> purchases) {
        this.purchases = purchases;
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
                + ", purchases=" + purchases
                + '}';
    }
}
