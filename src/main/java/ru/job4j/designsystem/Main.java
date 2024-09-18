package ru.job4j.designsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        File file = new File("logs");
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write("test string".getBytes());
        } catch (IOException e) {
            LOGGER.warn("warn message to the secondFileLog.txt", e);
        }
        LOGGER.trace("TRACE message");
        LOGGER.debug("DEBUG message");
        LOGGER.info("INFO message");
        LOGGER.error("ERROR simpleLog and secondFileLog");

    }
}
