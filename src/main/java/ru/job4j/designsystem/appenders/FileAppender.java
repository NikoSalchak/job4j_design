package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;

import java.io.*;

public class FileAppender extends AbstractAppender {
    private String filePath;

    public FileAppender(int logLevel, String filePath) {
        super(logLevel);
        this.filePath = filePath;
    }

    @Override
    public void append(LogEvent logEvent) {
        if (super.validateLevel(logEvent.getLogLevel())) {
            File file = new File(filePath);
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
                writer.println(logEvent.getMessage());
                if (logEvent.getThrowable() != null) {
                    logEvent.getThrowable().printStackTrace(writer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
