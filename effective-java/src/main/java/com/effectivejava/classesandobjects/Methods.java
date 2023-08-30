package com.effectivejava.classesandobjects;

public class Methods {

    public static void main(String[] args) {
        int x = 3;
        updateData(x);
        System.out.println("int x is: " + x);

        Integer y =5;
        updateData(x);
        System.out.println("Integer y is: " + y);

        Point p1 = new Point(3,4);
        movePoint(p1, 10, 10);
        System.out.println(p1);

    }

    public static void updateData(int p) {
        p++;
        p = 10;
    }

    public static void updateData(Integer p) {
        p++;
        p = 10;
    }

    public static void updateData(String p) {
        p = "10";
    }

    public static void movePoint(Point p, int deltaX, int deltaY) {
        p.x += deltaX;
        p.y += deltaY;

        p = new Point(0,0);
    }
}

class Point {

    public Point(int pX, int pY) {
        x = pX;
        y = pY;
    }

    int x;
    int y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}