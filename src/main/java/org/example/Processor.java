package org.example;

public class Processor {

    private String pattern;

    public Processor(String pattern) {
        this.pattern = pattern;
    }

    public boolean isValid(String line) {
        return line.matches(this.pattern);
    }

}
