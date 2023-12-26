package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void parseMethodWithoutParameters() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Array is empty");
    }

    @Test
    void parseMethodWithoutAssignment() {
        NameLoad nameLoad = new NameLoad();
        String word = "key:value";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(word)
                .hasMessageContaining("does not contain the symbol");
    }

    @Test
    void parseMethodWithoutKey() {
        NameLoad nameLoad = new NameLoad();
        String word = "=keyvalue";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(word)
                .hasMessageContaining("key");
    }

    @Test
    void parseMethodWithoutValue() {
        NameLoad nameLoad = new NameLoad();
        String word = "keyvalue=";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(word)
                .hasMessageContaining("value");
    }
}