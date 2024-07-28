package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void whenStartAtEqual3ThenFizz() {
        int startAt = 3;
        String expected = "Fizz";
        StringBuilder sb = Fool.checkComputerFizzBuzz(startAt);
        assertThat(sb.toString()).isEqualTo(expected);
    }

    @Test
    void whenStartAtEqual15ThenFizzBuzz() {
        int startAt = 15;
        String expected = "FizzBuzz";
        StringBuilder sb = Fool.checkComputerFizzBuzz(startAt);
        assertThat(sb.toString()).isEqualTo(expected);
    }

    @Test
    void whenStartAtEqual20ThenNotFizz() {
        int startAt = 20;
        String expected = "Fizz";
        StringBuilder sb = Fool.checkComputerFizzBuzz(startAt);
        assertThat(sb.toString()).isNotEqualTo(expected);
    }

    @Test
    void whenAnswerEqualFizzThenTrue() {
        int startAt = 6;
        String answer = "Fizz";
        boolean rsl = Fool.checkWrongInput(startAt, answer);
        assertThat(rsl).isTrue();
    }

    @Test
    void whenAnswerEqualFizzBuzzThenTrue() {
        int startAt = 30;
        String answer = "FizzBuzz";
        boolean rsl = Fool.checkWrongInput(startAt, answer);
        assertThat(rsl).isTrue();
    }

    @Test
    void whenAnswerNotEqualFizzBuzzThenFalse() {
        int startAt = 30;
        String answer = "30";
        boolean rsl = Fool.checkWrongInput(startAt, answer);
        assertThat(rsl).isFalse();
    }
}