package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String inPath = "lng.txt";
        String outPath = "result.txt";
        String pattern = "^(\"[0-9]*\";)*\"[0-9]*\"$";
        String line;
        HashMap<String, String[]> groups = new HashMap<>();

        Processor processor = new Processor(pattern);
        Reader reader = new Reader(inPath);

        while ((line = reader.readLine()) != null) {
            if (processor.isValid(line)) {
                String [] elements = new String[countChar(line, ';') + 1];
                elements = line.split(";");
            }
        }
        reader.close();
    }

    private static int countChar(String s, char c) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) count++;
        }
        return count;
    }
}