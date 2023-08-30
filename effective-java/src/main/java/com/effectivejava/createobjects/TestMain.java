package com.effectivejava.createobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        // Constructor
        Person andres = new Person("Andres", "Eraso", 'M');

        Person asesorInmobiliaria = new Person("Zonia");
        Person lilia = new Person("Lilia", null, 'F');

        // Static factory method
        Person julian = Person.createMan("Eraso", "Julian", 11);
        Person martina = Person.createWoman("Martina", "Eraso", 9);

        // Builder
        Person asesorConcesionario = Person.builder()
                .firstName("Juan Carlos")
                .gender('M')
                .build();

        Person luis = Person.builder()
                .firstName("Luis")
                .lastName("Eraso")
                .gender('M')
                .age(37)
                .build();

        Person leidy = Person.builder()
                .firstName("Leidy")
                .lastName("Garces")
                .gender('F')
                .build();

        // Java 9+
        List personasInmutable = List.of(andres, asesorInmobiliaria, lilia, julian, martina);
        //personasInmutable.add(asesorConcesionario);

        List personasArray = new ArrayList();
        personasArray.add(andres);
        personasArray.add(asesorInmobiliaria);
        personasArray.add(asesorConcesionario);
        personasArray.add(lilia);

        personasArray.add(julian);
        personasArray.add(martina);

        personasArray.add(luis);
        personasArray.add(leidy);

        // Expresión Lambda
        // forEach(Consumer<T> action) : void accept(T t);
        System.out.println("\nLista ordenada por orden de inserción");
        personasArray.forEach(p -> System.out.println(p));

        System.out.println("\nLista ordenada");
        Collections.sort(personasArray);
        personasArray.forEach(p -> System.out.println(p));

        System.out.println("\nLista ordenada por edad");
        Collections.sort(personasArray, new CompararPorEdad());
        personasArray.forEach(p -> System.out.println(p));

        // Clase anónima
        System.out.println("\nClase anónima. Lista ordenada por apellido");
        Collections.sort(personasArray,
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return (""+o1.getLastName())
                                .compareTo(""+o2.getLastName());
                    }
                });
        personasArray.forEach(p -> System.out.println(p));

        // Expresión Lambda
        System.out.println("\nExpresión Lambda. Lista ordenada por nombre");
        Collections.sort(personasArray,
                (Person p1, Person p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        personasArray.forEach(p -> System.out.println(p));

        // Expresión Lambda
        System.out.println("\nMethod parameter. Lista ordenada por edad");
        Collections.sort(personasArray, Comparator.comparing(Person::getAge));
        personasArray.forEach(p -> System.out.println(p));
        
    }
}
