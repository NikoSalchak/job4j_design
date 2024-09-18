package ru.job4j.designsystem.appenders;

import ru.job4j.designsystem.LogEvent;

import java.io.*;

public class FileAppender extends AbstractAppender {

    @Override
    public void append(LogEvent logEvent) {
        String[] rootLogger = super.properties.getRootConfigurations();
        for (int i = 0; i < rootLogger.length; i++) {
            if ("File".equals(super.properties.getProperty("appender.".concat(rootLogger[i])))
                    && super.validateLevel(rootLogger[i], logEvent.getLogLevel())) {
                File file = new File(super.properties.getProperty("appender.".concat(rootLogger[i]).concat(".file")));
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
}
