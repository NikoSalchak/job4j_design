package ru.job4j.ood.srp.lsp.store;

import ru.job4j.ood.srp.lsp.products.Food;

import java.util.ArrayList;

public class Shop extends AbstractStore {
    public Shop() {
        foods = new ArrayList<>();
    }

    @Override
    public Food add(Food food) {
        setProductId(food);
        double percent = foodQuality(food);
        if (percent <= 75 && percent >= 25) {
            foods.add(food);
        } else if (percent < 25 && percent > 0) {
            food.setDiscount(0.2);
            food.setPrice(food.getPrice() - food.getDiscount() * food.getPrice());
            foods.add(food);
        }
        return food;
    }
}
