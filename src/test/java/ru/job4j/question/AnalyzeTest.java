package ru.job4j.question;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class AnalyzeTest {

    @Test
    void whenNotChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1, u2, u3);
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(0, 0, 0));
    }

    @Test
    void whenOneChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1, new User(2, "BB"), u3);
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(0, 1, 0));
    }

    @Test
    void whenOneDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1, u3);
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(0, 0, 1));
    }

    @Test
    void whenOneAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "С");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1, u2, u3, new User(4, "D"));
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(1, 0, 0));
    }

    @Test
    void whenThreeAdded() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "С");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(
                u1,
                u2,
                u3,
                new User(4, "D"),
                new User(5, "E"),
                new User(6, "F")
        );
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(3, 0, 0));
    }

    @Test
    void whenTwoChanged() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1, new User(2, "BB"), new User(3, "CC"));
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(0, 2, 0));
    }

    @Test
    void whenTwoDeleted() {
        User u1 = new User(1, "A");
        User u2 = new User(2, "B");
        User u3 = new User(3, "C");
        Set previous = Set.of(u1, u2, u3);
        Set current = Set.of(u1);
        assertThat(Analyze.diff(previous, current)).isEqualTo(new Info(0, 0, 2));
    }
}