package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path src : sources) {
                String s = src.toString();
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(s))) {
                    zip.putNextEntry(new ZipEntry(s));
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateArgs(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        Path start = Path.of(argsName.get("d"));
        if (!Files.exists(start)) {
            throw new IllegalArgumentException(
                    String.format("Not Exist %s", start.toAbsolutePath())
            );
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException(
                    String.format("the file extension must start with '%s'", ".")
            );
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException(
                    String.format("the archive extension must be '%s'", ".zip")
            );
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        Zip testZip = new Zip();
        ArgsName argsName = ArgsName.of(args);
        testZip.validateArgs(args);
        List<Path> sources = Search.search(
                Paths.get(argsName.get("d")), path -> !path.toFile().getName().endsWith(argsName.get("e"))
        );
        testZip.packFiles(sources, new File(argsName.get("o")));
    }
}
