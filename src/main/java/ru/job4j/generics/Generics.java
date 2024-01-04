package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {

    public void printObject(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("animal", true, 100f));
        second.add(new Predator("Predator", true, 120f));
        third.add(new Tiger("Tiger", true, 200f));

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);

/*        generics.printBoundedWildCard(first);*/
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
/*        generics.printLowerBoundedWildCard(third);*/
    }
}
