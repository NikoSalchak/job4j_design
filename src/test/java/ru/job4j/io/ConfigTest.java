package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenHasCommentAndEmptyString() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.password")).isEqualTo("password");
    }

    @Test
    void whenStringWithoutKeyThenException() {
        String path = "./data/exceptionApp.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .message().isNotEmpty();
    }

    @Test
    void whenPairWithTwoEqual() {
        String path = "./data/severalPair.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Niko Salchak=");
    }
}