package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> chatLog = new ArrayList<>();
        List<String> botAnswers = readPhrases();
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        String input = "";
        while (!OUT.equals(input)) {
            input = scanner.nextLine();
            String bot = botAnswers.get(new Random().nextInt(botAnswers.size()));
            chatLog.add(input);
            chatLog.add(bot);
            if (OUT.equals(input)) {
                cont = false;
            } else if (STOP.equals(input)) {
                cont = false;
            } else if (CONTINUE.equals(input)) {
                cont = true;
            }
            if (cont) {
                System.out.println(bot);
            }
        }
        saveLog(chatLog);
    }


    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            list = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(path, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(
                "./data/ConsoleChatPath.txt", "./data/ConsoleChatBotAnswers.txt"
        );
        consoleChat.run();
    }
}
