package ru.job4j.designsystem.appenders;

import java.io.*;

public class FileAppender implements Appender {

    private String filePath;


    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(String message) {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)) {
            String string = String.format("%s%s", message, System.lineSeparator());
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
