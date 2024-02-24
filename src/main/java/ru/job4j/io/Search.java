package ru.job4j.io;

import ru.job4j.nio.BasicFileAttributeView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validateArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("program arguments were not found, please add program arguments");
        }
    }

    public static void main(String[] args) throws IOException {
        validateArgs(args);
        Path start = Paths.get(args[0]);
        BasicFileAttributes attrs = Files.readAttributes(start, BasicFileAttributes.class);
        if (!Files.exists(start)) {
            throw new IllegalArgumentException(String.format("Not Exist %s", start.toAbsolutePath()));
        }
        if (attrs.isRegularFile()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toAbsolutePath()));
        }
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }
}
