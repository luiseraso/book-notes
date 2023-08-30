package com.hackerranck.stringmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockString {

    public void execute(String s) {
        char[] characters = s.toCharArray();

        Map<Character, Integer> dictionary = new HashMap<>();
        for(char c: characters) {
            dictionary.put(c, dictionary.getOrDefault(c, 0)+ 1);
        }

        Integer media = 0;
        boolean isFirst = true;
        boolean hasDifferent = false;

        for(Integer l: dictionary.values()) {
            if(isFirst){
                media = l;
                isFirst = false;
            } else {
                if(l == media) {
                    continue;
                } else if(!hasDifferent && l==media+1) {
                    hasDifferent = true;
                    continue;
                } else {
                    System.out.println("NO");
                    break;
                }
            }
        }

        System.out.println("YES");

    }

    public void execute2(String s) {
        Map<Character, Long> dictionary = s.chars()
                .mapToObj(i -> (char) i)
                .collect(
                        Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));
    }
}
