package ru.geekbrains.java_one_lesson_one;

public class HomeWork {

    public static void main(String[] args) {
        float one = homeWorkOne(2, 3, 10, 3);
        boolean two = homeWorkTwo(10, 15);
        homeWorkThree(0);
        System.out.println(homeWorkFour("Дмитрий"));
        homeWorkFive(2020);
    }

    private static void homeWorkFive(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Високосный");
        } else {
            System.out.println("Не високосный");
        }
    }

    private static String homeWorkFour(String name) {
        return "Привет, " + name + "!";
    }

    private static void homeWorkThree(int a) {
        if (a >= 0) {
            System.out.println("число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    private static boolean homeWorkTwo(int a, int b) {
        if (a + b > 10 && a + b < 20) {
            return true;
        } else {
            return false;
        }
    }

    private static float homeWorkOne(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }
}