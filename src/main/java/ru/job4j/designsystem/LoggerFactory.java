package ru.job4j.designsystem;

import ru.job4j.designsystem.appenders.*;
import java.time.LocalDateTime;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new SimpleLogger(name);
    }

    static class SimpleLogger implements Logger {
        private String name;
        private PropertyReader properties;

        private SimpleLogger(String name) {
            this.name = name;
            this.properties = new PropertyReader();
        }

        @Override
        public String getName() {
            return this.name;
        }

        private int getPropertyAppenderLevel(String appenderLevel) {
            int logLevelCounter = 0;
            int rsl = 0;
            for (LogLevel logLvl : LogLevel.values()) {
                if (logLvl.name().equals(appenderLevel)) {
                    rsl = logLevelCounter;
                    break;
                }
                logLevelCounter++;
            }
            return rsl;
        }

        private void log(String message, LogLevel logLevel) {
            String[] rootLogger = properties.getRootConfigurations();
            AppenderOperator operator;
            LogInfo info = new SimpleLogInfo(LocalDateTime.now(), logLevel, this.name, message);
            for (int i = 0; i < rootLogger.length; i++) {
                if ("Console".equals(properties.getProperty("appender.".concat(rootLogger[i])))
                        && getPropertyAppenderLevel(properties.getProperty("appender.".concat(rootLogger[i]).concat(".level"))) <= logLevel.ordinal()) {
                    operator = new ConsoleAppenderOperator();
                    operator.operate(info);
                }
                if ("File".equals(properties.getProperty("appender.".concat(rootLogger[i])))
                        && getPropertyAppenderLevel(properties.getProperty("appender.".concat(rootLogger[i]).concat(".level"))) <= logLevel.ordinal()) {
                    operator = new FileAppenderOperator(properties.getProperty("appender.".concat(rootLogger[i]).concat(".file")));
                    operator.operate(info);
                }
            }
        }

        @Override
        public void trace(String message) {
            this.log(message, LogLevel.TRACE);
        }

        @Override
        public void debug(String message) {
            this.log(message, LogLevel.DEBUG);
        }

        @Override
        public void info(String message) {
            this.log(message, LogLevel.INFO);
        }

        @Override
        public void warn(String message) {
            this.log(message, LogLevel.WARN);
        }

        @Override
        public void error(String message) {
            this.log(message, LogLevel.ERROR);
        }
    }
}
