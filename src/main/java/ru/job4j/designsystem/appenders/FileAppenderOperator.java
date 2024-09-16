package ru.job4j.designsystem.appenders;

public class FileAppenderOperator extends AppenderOperator {
    String path;

    public FileAppenderOperator(String path) {
        this.path = path;
    }

    @Override
    public Appender createAppender() {
        return new FileAppender(path);
    }
}
