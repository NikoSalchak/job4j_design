package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
@Disabled
class SentenceGeneratorTest {

    @Test
    void whenMapContainNameAndSubject() {
        Generator generator = new SentenceGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        String expected = "I am Petr Arsentev, Who are you?";
        Map<String, String> map = Map.of("name", "Petr Arsentev", "subject", "you");
        String rsl = generator.produce(template, map);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenMapDoesNotContainNameButHaveSubject() {
        Generator generator = new SentenceGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(MapMissingKeysException.class)
                .hasMessage("Map missing key: \"name\"");
    }

    @Test
    void whenMapContainUnwantedKeys() {
        Generator generator = new SentenceGenerator();
        String template = "I am Petr Arsentev, Who are you?";
        Map<String, String> map = Map.of("name", "Petr Arsentev", "subject", "you", "extraKey", "value");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(MapExtraKeysException.class)
                .hasMessage("Map contain unwanted keys: extraKey");

    }
}