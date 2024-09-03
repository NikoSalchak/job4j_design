package ru.job4j.ood.srp.lsp.store;

import ru.job4j.ood.srp.lsp.products.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foods;
    protected int ids = 1;

    public AbstractStore() {
    }

    protected double foodQuality(Food food) {
        double shelfLife = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double remain = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        return remain / shelfLife * 100;
    }

    protected void setProductId(Food food) {
        if (food.getProductId() == 0) {
            food.setProductId(ids++);
        }
    }

    private int indexOf(int productId) {
        int rsl = -1;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getProductId() == productId) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    @Override
    public void deleteById(int productId) {
        int index = indexOf(productId);
        if (index != -1) {
            foods.remove(index);
        }
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(foods);
    }

    @Override
    public List<Food> findByName(String name) {
        List<Food> rsl = new ArrayList<>();
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                rsl.add(food);
            }
        }
        return rsl;
    }

    @Override
    public Food findById(int productId) {
        int index = indexOf(productId);
        return index != -1 ? foods.get(index) : null;
    }
}
