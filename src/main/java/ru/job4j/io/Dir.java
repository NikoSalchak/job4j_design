package ru.job4j.io;

import java.io.File;

public class Dir {
    private static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not Exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                System.out.printf("Имя файла - %s, Размер файла - %s \n", subfile.getName(), subfile.length());
            } else {
                System.out.printf("Имя файла - %s, Размер файла - %s \n", subfile.getName(), getFolderSize(subfile));
            }
        }
    }
}