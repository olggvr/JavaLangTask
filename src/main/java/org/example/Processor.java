package org.example;

import java.util.*;

public class Processor {

    private String pattern;

    public Processor(String pattern) {
        this.pattern = pattern;
    }

    public boolean isValid(String line) {
        return line.matches(this.pattern);
    }

    public Map<Set<String>, List<String>> process(String line, Map<Set<String>, List<String>> groupMap, List<Set<String>> groups) {
        Set<String> tmp = getStrValues(line.split(";"));
        int countCons = 0;
        int groupIndex = 0;
        for (Set<String> group: groups){
            if (!Collections.disjoint(group, tmp)){
                countCons++;
                if(countCons > 1){
                    groups.get(groupIndex).addAll(group);
                    groups.remove(group);
                }
                else{
                    groupIndex = groups.indexOf(group);
                    group.addAll(tmp);
                    groupMap.get(group).add(line);
                }
            }
            else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(line);
                groupMap.put(tmp, newGroup);
            }
        }
        return groupMap;
    }

    private static Set<String> getStrValues(String [] s){
        Set<String> setValues = new HashSet<>();
        for (String str : s)
            if(!Objects.equals(str, "")) setValues.add(str);
        return setValues;
    }
}
