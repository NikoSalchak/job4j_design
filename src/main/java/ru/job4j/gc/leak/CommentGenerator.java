package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {
    private List<Comment> comments = new ArrayList<>();
    private List<String> phrases;
    private UserGenerator userGenerator;
    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        phrases = read("src/main/java/ru/job4j/gc/leak/files/phrases.txt");
    }


    public List<Comment> getComments() {
        return comments;
    }


    @Override
    public void generate() {
        comments.clear();
        String newLine = System.lineSeparator();
        for (int i = 0; i < 50; i++) {
            String comment = String.format("%s%s%s%s%s",
                    phrases.get(random.nextInt(phrases.size())), newLine,
                    phrases.get(random.nextInt(phrases.size())), newLine,
                    phrases.get(random.nextInt(phrases.size()))
            );
            comments.add(new Comment(comment, userGenerator.randomUser()));
        }
    }

    @Override
    public List<String> read(String path) {
        return Generate.super.read(path);
    }
}
