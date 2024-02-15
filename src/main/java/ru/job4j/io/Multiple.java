package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Multiple {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/multipleResult.txt")) {
            Integer a = 1 * 2;
            output.write("1 * 2 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 3;
            output.write("1 * 3 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 4;
            output.write("1 * 4 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 5;
            output.write("1 * 5 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 6;
            output.write("1 * 6 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 7;
            output.write("1 * 7 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 8;
            output.write("1 * 8 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
            a = 1 * 9;
            output.write("1 * 9 = ".getBytes());
            output.write(a.toString().getBytes());
            output.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
