package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static StringBuilder checkComputerFizzBuzz(int startAt) {
        StringBuilder sb = new StringBuilder();
        if (startAt % 3 == 0) {
            sb.append("Fizz");
        }
        if (startAt % 5 == 0) {
            sb.append("Buzz");
        }
        if (startAt % 3 != 0 && startAt % 5 != 0) {
            sb.append(startAt);
        }
        return sb;
    }

    public static boolean checkWrongInput(int starAt, String answer) {
        String key = "FizzBuzz";
        boolean rsl = true;
        if (starAt % 3 == 0 || starAt % 5 == 0) {
            if (!key.contains(answer)) {
                rsl = false;
            }
        } else if (!String.valueOf(starAt).equals(answer)) {
            rsl = false;
        }
        return rsl;
    }


    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            StringBuilder computerAnswer = checkComputerFizzBuzz(startAt);
            System.out.println(computerAnswer);
            startAt++;
            var answer = input.nextLine();
            if (!checkWrongInput(startAt, answer)) {
                System.out.println("Ошибка. начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}
