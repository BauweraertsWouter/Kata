package com.wouter.kata.stringCalc;

/**
 * Created by Wouter on 28/06/2016.
 */
public class StringCalc {
    public int count(String s) {
        if (s.length()==0){ return 0;}
        else {
            String[] str = tokenize(s);
            return str.length;
        }
    }

    private String[] tokenize(String s) {
        String[] strings = s.split("[,\\n]");
        if (strings[0].matches("[0-9]+")){return strings;}
        else return delimit(strings[0],strings[1]);
    }

    private String[] delimit(String delimiter, String string) {
        return string.split(delimiter);
    }

    public int add(String s) throws IllegalArgumentException{
        if (s.length()==0) return 0;
        String[] strings = tokenize(s);
        int[] ints = new int[strings.length];
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
            if (ints[i]<0) throw new IllegalArgumentException("negatives not allowed");
            if (ints[i] <=1000) sum += ints[i];
        }
        return sum;
    }
}
