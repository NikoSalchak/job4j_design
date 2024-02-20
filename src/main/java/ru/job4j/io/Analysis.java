package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             PrintWriter printWriter = new PrintWriter(new FileOutputStream(target))) {
            StringBuilder sb = new StringBuilder();
            String line;
            boolean isWork = true;
            while ((line = bufferedReader.readLine()) != null) {
                if ((line.contains("400") || line.contains("500")) && isWork) {
                    line = line.split(" ")[1];
                    sb.append(line + ";");
                    isWork = false;
                }
                if ((line.contains("200") || line.contains("300")) && !isWork) {
                    line = line.split(" ")[1];
                    sb.append(line + ";");
                    isWork = true;
                    sb.append("\n");
                }
            }
            printWriter.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
