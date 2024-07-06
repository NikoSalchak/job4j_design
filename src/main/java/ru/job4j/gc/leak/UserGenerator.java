package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {
    private List<String> names;
    private List<String> surnames;
    private List<String> patrons;
    private List<User> users = new ArrayList<>();
    private Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        String separator = " ";
        for (int i = 0; i < 1000; i++) {
            String authors = String.format(
                    "%s%s%s%s%s", surnames.get(random.nextInt(surnames.size())), separator,
                    names.get(random.nextInt(names.size())), separator,
                    patrons.get(random.nextInt(patrons.size()))
            );
            users.add(new User(authors));
        }
    }

    private void readAll() {
        names = read("src/main/java/ru/job4j/gc/leak/files/names.txt");
        surnames = read("src/main/java/ru/job4j/gc/leak/files/surnames.txt");
        patrons = read("src/main/java/ru/job4j/gc/leak/files/patr.txt");
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<String> read(String path) {
        return Generate.super.read(path);
    }
}
