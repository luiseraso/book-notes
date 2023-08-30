package com.effectivejava.createobjects;

public class Person implements Comparable<Person>
{

    private String firstName;
    private String lastName;
    private int age;
    private char gender;

    public Person() {
    }

    // Constructores. Patron telescópico
    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, char gender) {
        if(!validGender(gender)) {
            throw new IllegalArgumentException("Gender not valid!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, char gender, int age) {
        if(!validGender(gender)) {
            throw new IllegalArgumentException("Gender not valid!");
        }
        if(!validAge(age)) {
            throw new IllegalArgumentException("Age not valid!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public static Person createMan(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, 'M', age);
    }

    public static Person createWoman(String firstName, String lastName, int age) {
        return new Person(firstName, lastName, 'F', age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Builder -- Inner class, Clase Interna.
    public static final class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private char gender;

        private Builder() {
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(char gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            Person person = new Person(firstName, lastName, gender, age);
            return person;
        }
    }

    private static boolean validAge(int age) {
        return age >= 0 ? true : false;
    }

    private static boolean validGender(char gender) {
        return (gender == 'M' || gender == 'F') ? true : false;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.firstName.compareTo(o.firstName);
    }
}
