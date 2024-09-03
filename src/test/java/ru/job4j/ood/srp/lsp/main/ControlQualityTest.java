package ru.job4j.ood.srp.lsp.main;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.lsp.products.Bread;
import ru.job4j.ood.srp.lsp.products.Food;
import ru.job4j.ood.srp.lsp.products.Milk;
import ru.job4j.ood.srp.lsp.products.Sugar;
import ru.job4j.ood.srp.lsp.store.Shop;
import ru.job4j.ood.srp.lsp.store.Store;
import ru.job4j.ood.srp.lsp.store.Trash;
import ru.job4j.ood.srp.lsp.store.WareHouse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenAddFoodThenWareHouse() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food milk = new Milk(
                "cow milk",
                now.plusDays(11),
                now.minusDays(2),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(milk);
        assertThat(stores.get(0).findById(1)).isEqualTo(milk);
    }

    @Test
    void whenAddFoodThenShop() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food bread = new Bread(
                "white bread",
                now.plusDays(10),
                now.minusDays(4),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(bread);
        assertThat(stores.get(1).findByName("white bread")).contains(bread);
    }

    @Test
    void whenAddFoodThenShopButDeletedInTheEnd() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food bread = new Bread(
                "white bread",
                now.plusDays(10),
                now.minusDays(4),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(bread);
        assertThat(stores.get(1).findAll()).contains(bread);
        stores.get(1).deleteById(1);
        assertThat(stores.get(1).findAll()).isEmpty();
    }

    @Test
    void whenAddFoodThenShopWithDiscount() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food sugar = new Sugar(
                "sugar",
                now.plusDays(4),
                now.minusDays(13),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(sugar);
        assertThat(stores.get(1).findAll()).contains(sugar);
        assertThat(stores.get(1).findById(1).getPrice()).isEqualTo(80);
    }

    @Test
    void whenAddFoodThenTrash() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food milk = new Milk(
                "cow milk",
                now.plusDays(0),
                now.minusDays(8),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(milk);
        assertThat(stores.get(2).findAll()).contains(milk);
    }

    @Test
    void whenAddFoodThenResortThenWareHouse() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food milk = new Milk(
                "cow milk",
                now.plusDays(11),
                now.minusDays(2),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(milk);
        quality.resort(stores);
        assertThat(stores.get(0).findById(1)).isEqualTo(milk);
    }

    @Test
    void whenAddFoodResultShopThenResortTrash() {
        List<Store> stores = Arrays.asList(
                new WareHouse(),
                new Shop(),
                new Trash()
        );
        LocalDate now = LocalDate.now();
        Food bread = new Bread(
                "white bread",
                now.plusDays(10),
                now.minusDays(4),
                100);
        ControlQuality quality = new ControlQuality(stores);
        quality.sortProduct(bread);
        assertThat(stores.get(1).findByName("white bread")).contains(bread);
        bread.setExpiryDate(now.minusDays(1));
        quality.resort(stores);
        assertThat(stores.get(2).findById(1)).isEqualTo(bread);
    }
}