package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(target))) {
            String line;
            boolean isWork = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (((line.contains("400") || line.contains("500")) && !isWork)
                        || ((line.contains("200") || line.contains("300")) && isWork)) {
                    isWork = !isWork;
                    line = line.split(" ")[1];
                    printWriter.printf("%s%s", line, ";");
                    line = isWork ? "" : System.lineSeparator();
                    printWriter.print(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
