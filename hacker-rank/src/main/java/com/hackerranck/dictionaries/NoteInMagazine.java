package com.hackerranck.dictionaries;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NoteInMagazine {

    public void execute(List<String> magazine, List<String> note) {

        Map<String, Long> dictionary = magazine.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(dictionary);
        System.out.println(note);

        for(String n: note) {
            Long i = dictionary.getOrDefault(n, 0L);
            if(i == 0L ) {
                System.out.println("No");
                return;
            } else {
                dictionary.put(n, --i);
                continue;
            }
        }
        System.out.println("Si");
    }
}
