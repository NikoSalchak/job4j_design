package ru.job4j.ood.srp.lsp.store;


import ru.job4j.ood.srp.lsp.products.Food;

import java.util.ArrayList;

public class WareHouse extends AbstractStore {
    public WareHouse() {
        foods = new ArrayList<>();
    }

    @Override
    public Food add(Food food) {
        double percent = foodQuality(food);
        if (percent > 75) {
            setProductId(food);
            foods.add(food);
        }
        return food;
    }
}
