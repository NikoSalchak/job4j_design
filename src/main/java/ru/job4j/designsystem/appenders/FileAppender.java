package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogLevel;

import java.io.*;

public class FileAppender extends AbstractAppender {

    @Override
    public void append(String message, LogLevel logLevel) {
        String[] rootLogger = properties.getRootConfigurations();
        for (int i = 0; i < rootLogger.length; i++) {
            if ("File".equals(properties.getProperty("appender.".concat(rootLogger[i])))
                    && super.validateLevel(rootLogger[i], logLevel)) {
                File file = new File(properties.getProperty("appender.".concat(rootLogger[i]).concat(".file")));
                try (FileWriter writer = new FileWriter(file, true)) {
                    String string = String.format("%s%s", message, System.lineSeparator());
                    writer.write(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
