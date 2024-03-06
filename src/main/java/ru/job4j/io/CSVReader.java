package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        validate(argsName);
        try (FileInputStream input = new FileInputStream(argsName.get("path"));
             PrintStream out = (argsName.get("out").equals("stdout")) ? System.out : new PrintStream(argsName.get("out"));
             PrintStream output = new PrintStream(out)) {
            List<String> filters = Arrays.asList(argsName.get("filter").split(","));
            List<List<String>> csvList = new ArrayList<>();
            String delimiter = argsName.get("delimiter");
            String newLine = System.lineSeparator();
            Scanner scanner = new Scanner(input).useDelimiter(newLine);
            while (scanner.hasNext()) {
                csvList.add(Arrays.asList(scanner.next().split(delimiter)));
            }
            int[] columns = new int[csvList.get(0).size()];
            StringJoiner sj = new StringJoiner(delimiter);
            StringJoiner resultSJ = new StringJoiner(newLine);
            for (int i = 0; i < filters.size(); i++) {
                columns[i] = csvList.get(0).indexOf(filters.get(i));
            }
            for (int i = 0; i < csvList.size(); i++) {
                for (int j = 0; j < filters.size(); j++) {
                    String[] result = getColumn(csvList, columns[j]);
                    sj.add(result[i]);
                }
                resultSJ.add(sj.toString());
                sj = new StringJoiner(delimiter);
            }
            output.println(resultSJ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getColumn(List<List<String>> list, int index) {
        String[] column = new String[list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            column[i] = list.get(i).get(index);
        }
        return column;
    }

    private static void validate(ArgsName argsName) {
        boolean filter = true;
        if (!(argsName.get("path").endsWith(".csv"))) {
            throw new IllegalArgumentException(
                    String.format("Error: the value of the path key must have a \'%s\' extension", ".csv")
            );
        }
        if (!(argsName.get("delimiter").equals(";") || argsName.get("delimiter").equals(","))) {
            throw new IllegalArgumentException(
                    String.format("Error: the value of the delimiter key must be \'%s\' or \'%s\'", ";", ",")
            );
        }
        if (!(argsName.get("out").endsWith(".csv") || argsName.get("out").equals("stdout"))) {
            throw new IllegalArgumentException(
                    String.format("Error: the value of the out key must have a "
                            + "\'%s\' extension or must be \'%s\'", ".csv", "stdout")
            );
        }
        for (String substring : "name,age,last_name,education".split(",")) {
            if (argsName.get("filter").contains(substring)) {
                filter = false;
            }
        }
        if (filter) {
            throw new IllegalArgumentException(
                    String.format("Error: The value of the filter key must contain the following headers: "
                            + "\'%s\',%s\',%s\',%s\' without spacebar", "name", "age", "last_name", "education")
            );
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
