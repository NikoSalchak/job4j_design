package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        map.computeIfAbsent(fileProperty, k -> new ArrayList<>()).add(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public void resultMap() {
        map = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<FileProperty, List<Path>> fileProperty : map.entrySet()) {
            String newLine = System.lineSeparator();
            System.out.printf("%s - %s%s%s", fileProperty.getKey().getName(),
                    fileProperty.getKey().getSize(), "byte", newLine);
            for (Path path : fileProperty.getValue()) {
                System.out.printf("%s%s", path, newLine);
            }
        }
    }
}
