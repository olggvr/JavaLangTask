package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class Reader {

    private BufferedReader reader;
    private String currentLine;

    public Reader(String path) {
        try {
            reader = new BufferedReader(new java.io.FileReader(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readLine() {
        try{
            currentLine = reader.readLine();
            return currentLine;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void close() {
        try{
            if(reader != null) {reader.close();}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
