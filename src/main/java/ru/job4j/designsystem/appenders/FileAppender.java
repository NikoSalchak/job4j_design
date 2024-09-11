package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogLevel;
import ru.job4j.designsystem.Logger;

public class FileAppender extends ConsoleAppender {
    private String filePath;
    public FileAppender(Logger logger, String filePath) {
        super(logger);
        this.filePath = filePath;
    }

    @Override
    public void append(String message) {
        if (logger.getLogLevel() == LogLevel.ERROR) {
            System.out.println("вывод в файл");
        }
    }
}
