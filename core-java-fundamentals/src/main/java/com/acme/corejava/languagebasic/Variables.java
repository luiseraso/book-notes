package com.acme.corejava.languagebasic;

public class Variables {

    public static void main(String[] args) {
        Bicycle b1 = new Bicycle(2, 4, 6);
        Bicycle b2 = new Bicycle(3, 5, 7);

        b1.changeCadence(8);
        b1.changeNumGears(10);
        b2.changeCadence(9);

        b1.printStates();// cadence: 8, speed: 4, gear: 6, numGears: 10
        b2.printStates();// cadence: 9, speed:5 , gear: 7, numGears: 5

    }
}

class Bicycle {

    static int numGears = 5;

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    public Bicycle() {}

    public Bicycle(int c, int s, int g) {
        cadence = c;
        speed = s;
        gear = g;
    }

    void changeNumGears(int n) {
        numGears = n;
    }

    void changeCadence(int newValue) {
        cadence = newValue;
    }

    void changeGear(int newValue) {
        gear = newValue;
    }

    void speedUp(int increment) {
        speed = speed + increment;
    }

    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println(
                "cadence:" + cadence +
                " speed:" + speed +
                " gear:" + gear +
                " numGears: "+ numGears);
    }
}
