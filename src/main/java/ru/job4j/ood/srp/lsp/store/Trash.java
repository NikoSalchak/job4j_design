package ru.job4j.ood.srp.lsp.store;

import ru.job4j.ood.srp.lsp.products.Food;

import java.util.ArrayList;

public class Trash extends AbstractStore {

    public Trash() {
        foods = new ArrayList<>();
    }

    @Override
    public Food add(Food food) {
        double percent = foodQuality(food);
        if (percent <= 0) {
            food.setProductId(ids++);
            foods.add(food);
        }
        return food;
    }
}
