package ru.job4j.ood.srp.lsp.store;

import ru.job4j.ood.srp.lsp.products.Food;

import java.util.List;

public interface Store {

    Food add(Food food);

    void deleteById(int productId);

    List<Food> findAll();

    List<Food> findByName(String name);

    Food findById(int productId);
}
