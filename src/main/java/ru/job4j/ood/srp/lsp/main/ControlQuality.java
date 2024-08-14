package ru.job4j.ood.srp.lsp.main;

import ru.job4j.ood.srp.lsp.products.Bread;
import ru.job4j.ood.srp.lsp.products.Food;
import ru.job4j.ood.srp.lsp.products.Milk;
import ru.job4j.ood.srp.lsp.store.Shop;
import ru.job4j.ood.srp.lsp.store.Store;
import ru.job4j.ood.srp.lsp.store.Trash;
import ru.job4j.ood.srp.lsp.store.WareHouse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> store) {
        this.stores = store;
    }

    public void sortProduct(Food food) {
        for (Store store : stores) {
            store.add(food);
        }
    }

    public static void main(String[] args) {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        Food cowMilk = new Milk(
                "cow milk",
                LocalDate.of(2024, 8, 20),
                LocalDate.of(2024, 8, 12),
                100
        );
        Food notCowMilk = new Milk(
                "not cow milk",
                LocalDate.of(2024, 8, 16),
                LocalDate.of(2024, 8, 1),
                100
        );
        Food bread = new Bread(
                "white bread",
                LocalDate.of(2024, 8, 18),
                LocalDate.of(2024, 7, 1),
                40
        );
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(cowMilk);
        quality.sortProduct(notCowMilk);
        quality.sortProduct(bread);
        System.out.println(quality.stores.get(0).findAll());
        for (Food food : quality.stores.get(1).findAll()) {
            System.out.println(food);
        }
    }
}
