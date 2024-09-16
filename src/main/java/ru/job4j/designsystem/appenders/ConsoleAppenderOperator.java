package ru.job4j.designsystem.appenders;

public class ConsoleAppenderOperator extends AppenderOperator {

    @Override
    public Appender createAppender() {
        return new ConsoleAppender();
    }
}
