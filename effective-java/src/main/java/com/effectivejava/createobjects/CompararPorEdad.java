package com.effectivejava.createobjects;

import java.util.Comparator;

public class CompararPorEdad implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
