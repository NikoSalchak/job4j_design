package ru.job4j.cache;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }


    @Override
    protected String load(String key) {
        Path path = Path.of(cachingDir, key);
        String newLine = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try (FileInputStream input = new FileInputStream(path.toString())) {
            Scanner scanner = new Scanner(input).useDelimiter(newLine);
            while (scanner.hasNext()) {
                sb.append(scanner.next()).append(newLine);
            }
            put(path.getFileName().toString(), sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
