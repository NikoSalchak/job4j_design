package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.HashMap;

public class WebShoesStore {
    private HashMap<Customer, ArrayList<Shoes>> salesList = new HashMap<>();

    public void buy(Customer customer) {
        System.out.println("При покупке обуви, она добавляется в список покупок покупателя и salesList магазина");
    }

    public void refund(Customer customer) {
        System.out.println("Возврат обуви в магазин. Обувь будет удалена из salesList магазина");
    }

    public HashMap<Customer, ArrayList<Shoes>> salesReport() {
        return salesList;
    }

}
