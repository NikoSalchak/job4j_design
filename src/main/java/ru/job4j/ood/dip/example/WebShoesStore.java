package ru.job4j.ood.dip.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebShoesStore {
    List<Product> shop;
    Map<Purchaser, Order> purchases = new HashMap<>();

    public WebShoesStore(List<Product> shop) {
        this.shop = shop;
    }

    public void buy(Purchaser purchaser, int select) {
        System.out.println("Покупатель выбирает товары из списка shop и формируется карта покупатель заказ");
    }

    public void refund(Purchaser purchaser) {
        System.out.println("Покупатель может вернуть заказ");
    }

    public Map<Courier, Map<Purchaser, Order>> sendOrders(Courier courier) {
        System.out.println("Курьер получает карту покупатели их заказы чтобы доставить покупателям их заказы");
        return null;
    }
}
