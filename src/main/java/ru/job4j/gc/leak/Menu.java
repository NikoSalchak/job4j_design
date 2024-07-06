package ru.job4j.gc.leak;

import java.util.Random;
import java.util.Scanner;

public class Menu {

    private void start(CommentGenerator commentGenerator, Scanner scanner, UserGenerator userGenerator, PostStore postStore) {
        boolean run = true;
        int addPost = 1;
        int addManyPost = 2;
        int showAllPosts = 3;
        int deletePosts = 4;
        String menu = """
            Введите 1 для создания поста.
            Введите 2, чтобы создать определенное количество постов.
            Введите 3, чтобы показать все посты.
            Введите 4, чтобы удалить все посты.
            Введите любое другое число для выхода.
            """;
        String select = "Выберите меню";
        String count = "Выберите количество создаваемых постов";
        String textOfPosts = "Введите текст";
        String forDelete = "Все посты удалены";
        String exit = "Конец работы";
        while (run) {
            System.out.println(menu);
            System.out.println(select);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (addPost == userChoice) {
                System.out.println(textOfPosts);
                String text = scanner.nextLine();
                userGenerator.generate();
                commentGenerator.generate();
                postStore.add(new Post(text, commentGenerator.getComments()));
            } else if (addManyPost == userChoice) {
                System.out.println(textOfPosts);
                String text = scanner.nextLine();
                System.out.println(count);
                String countPosts = scanner.nextLine();
                for (int i = 0; i < Integer.parseInt(countPosts); i++) {
                    createPost(commentGenerator, userGenerator, postStore, text);
                }
            } else if (showAllPosts == userChoice) {
                System.out.println(PostStore.getPosts());
            } else if (deletePosts == userChoice) {
                System.out.println(forDelete);
                postStore.removeAll();
            } else {
                run = false;
                System.out.println(exit);
            }
        }
    }

    private void createPost(CommentGenerator commentGenerator, UserGenerator userGenerator, PostStore postStore, String text) {
        userGenerator.generate();
        commentGenerator.generate();
        postStore.add(new Post(text, commentGenerator.getComments()));
    }

    public static void main(String[] args) {
        Random random = new Random();
        UserGenerator userGenerator = new UserGenerator(random);
        CommentGenerator commentGenerator = new CommentGenerator(random, userGenerator);
        Scanner scanner = new Scanner(System.in);
        PostStore postStore = new PostStore();
        new Menu().start(commentGenerator, scanner, userGenerator, postStore);
    }
}
