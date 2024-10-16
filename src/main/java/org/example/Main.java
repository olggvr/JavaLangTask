package org.example;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String inPath = "test.txt";
        String outPath = "result.txt";
        String pattern = "^(\"[0-9]*\";)*\"[0-9]*\"$";
        String line;
        List<Set<String>> groups = new ArrayList<>();
        Map<Set<String>, List<String>> groupMap = new HashMap<>();

        Processor processor = new Processor(pattern);

        try(BufferedReader reader = new BufferedReader(new FileReader(inPath))){
            while ((line = reader.readLine()) != null) {
                if (processor.isValid(line))
                    groupMap = processor.process(line, groupMap, groups);
            }
            output(outPath, groupMap);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private static void output(String path, Map<Set<String>, List<String>> groupMap) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        int counter = 1;
        for (Set<String> group: groupMap.keySet()) {
            writer.write("Group " + counter);
            writer.newLine();
            for (String str : groupMap.get(group)) {
                writer.write(str);
                writer.newLine();
            }
            counter++;
        }
    }
}