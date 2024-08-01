package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebAutoPartsStore {

    public void buyProduct(Customer customer) {
        System.out.println("покупка товара покупателем");
    }
    public void refundProduct(Customer customer) {
        System.out.println("Возврат товара покупателем");
    }
    public void buyProductOnCredit(Customer customer) {
        System.out.println("покупка товара покупателем в кредит");
    }

    public void addProductForSale(Product product) {
        System.out.println("Добавление товара в магазин");
    }
    public void removeProducts(Product product) {
        System.out.println("убрать товар с продажи");
    }
    public void putProductPrice(Product product) {
        System.out.println("операции с ценой товара");
    }

    public List<Product> sendProduct(Customer customer) {
        System.out.println("отправить товар выбранный покупателем");
        return new ArrayList<>();
    }
    public List<Product> getProductInTheStore(Customer customer) {
        System.out.println("получение товара покупателем в магазине");
        return new ArrayList<>();
    }

    public void soldProducts(Customer customer) {
        Map<Customer, List<Product>> goods = new HashMap<>();
        System.out.println("список проданных товаров");
    }
}
