package ru.job4j.designsystem;

import ru.job4j.designsystem.appenders.Appender;
import ru.job4j.designsystem.appenders.FileAppender;
import ru.job4j.designsystem.appenders.ConsoleAppender;


public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("log", LogLevel.TRACE);
        Appender appender = new ConsoleAppender(logger);
        appender.append("s");
        Appender appender1 = new FileAppender(logger, "./simpleLog.txt");
        appender.append("message");
        appender1.append("message2");
    }
}
