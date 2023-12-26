package ru.job4j.assertj;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .anyMatch(e -> e.contains("five"))
                .noneMatch(e -> e.length() > 10)
                .filteredOnAssertions(e -> assertThat(e.length()).isGreaterThan(4))
                .hasSize(3)
                .contains("first");
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "first", "first", "four", "five");
        assertThat(list)
                .hasSize(5)
                .contains("five", "first", "first")
                .containsOnly("first", "four", "five")
                .containsExactly("first", "first", "first", "four", "five")
                .containsExactlyInAnyOrder("first", "four", "five", "first", "first")
                .containsAnyOf("six", "seven", "first")
                .doesNotContain("zero", "eleven")
                .startsWith("first", "first")
                .endsWith("four", "five")
                .containsSequence("first", "first")
                .isNotNull()
                .anySatisfy(e -> assertThat(e).isEqualTo("first"))
                .element(4)
                .isEqualTo("five")
                .isNotNull();
        assertThat(list)
                .filteredOnAssertions(e -> assertThat(e.length()).isLessThan(5))
                .hasSize(2)
                .first().isEqualTo("four");

    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> list = simpleConvert.toSet("first", "first", "first", "two", "three", "four", "five");
        assertThat(list)
                .hasSize(5)
                .contains("four", "five")
                .containsOnly("two", "three", "four", "five", "first")
                .containsExactlyInAnyOrder("first", "four", "five", "two", "three")
                .containsAnyOf("six", "seven", "first")
                .anySatisfy(e -> {
                    assertThat(e.length()).isLessThan(5);
                    assertThat(e.length()).isEqualTo(3);
                })
                .last()
                .isNotNull();
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "2", "3", "4");
        assertThat(map).hasSize(4)
                .containsKeys("1", "2", "3")
                .containsValues(0, 1, 2, 3)
                .isNotEmpty()
                .contains(entry("1", 0))
                .containsAnyOf(entry("200", 199), entry("4", 3), entry("6", 5));

    }
}