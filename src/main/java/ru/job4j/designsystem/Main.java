package ru.job4j.designsystem;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.trace("TRACE message");
        LOGGER.debug("DEBUG message");
        LOGGER.info("INFO message");
        LOGGER.warn("WARN message");
        LOGGER.error("ERROR message after refactoring");
    }
}
