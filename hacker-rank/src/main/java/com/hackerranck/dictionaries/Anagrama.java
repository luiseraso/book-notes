package com.hackerranck.dictionaries;

import java.util.HashMap;
import java.util.Map;

public class Anagrama {

    public static void main(String[] args) {
        String ang = "aabbcde";
        String wrd = "aabbcdej";

        System.out.println(execute(ang, wrd));
    }
    public static boolean execute(String dictionary, String word) {
        Map<Character, Integer> dictionaryHash = wordToDictionary(dictionary);
        Map<Character, Integer> wordHash = wordToDictionary(word);

        return  wordHash.entrySet().stream()
                .filter(c -> notCompleteInDictionary(c, dictionaryHash))
                .findAny()
                .isEmpty();
    }

    private static Map<Character, Integer> wordToDictionary(String word) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for(char c: word.toCharArray()) {
            dictionary.put(c, dictionary.getOrDefault(c, 0)+1 );
        }
        return dictionary;
    }

    private static boolean notCompleteInDictionary(Map.Entry<Character, Integer> c, Map<Character, Integer> dictionary) {
        return dictionary.getOrDefault(c.getKey(), 0) < c.getValue();
    }
}
