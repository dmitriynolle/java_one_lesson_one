package ru.geekbrains.java_one_lesson_one;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {

//        задание один
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        homeWorkOne(arr1);
        System.out.println(Arrays.toString(arr1));

//        задание два
        int[] arr2 = new int[8];
        homeWorkTwo(arr2);
        System.out.println(Arrays.toString(arr2));

//        задание три
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        homeWorkThree(arr3);
        System.out.println(Arrays.toString(arr3));

//        задание четыре
        int[] arr4 = new int[10];
        for (int x = 0; x < arr4.length; x++)
            arr4[x] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(arr4));
        homeWorkFour(arr4);

//        задание пять
        int[][] arr5 = new int[10][10];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i][i] = 1;
            arr5[i][arr5.length - 1 - i] = 1;
            System.out.println(Arrays.toString(arr5[i]));
        }

//        задание шесть
        int[] arr6 = new int[5];
        for (int i = 0; i < arr6.length; i++)
            arr6[i] = (int) (Math.random() * 3);
        System.out.println(homeWorkSix(arr6));

//        задание семь
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int n = -2;
        homeWorkSeven(arr7, n);
        System.out.println(Arrays.toString(arr7));
    }

    private static void homeWorkSeven(int[] arr, int n) {
        for (int i = 0; i< Math.abs(n); i++){
            if (n>0){
                int element = 0;
                element = arr[0];
                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
                arr[arr.length-1] = element;
            } else if (n<0){
                int element = 0;
                element = arr[arr.length-1];
                System.arraycopy(arr, 0, arr, 1, arr.length - 1);
                arr[0] = element;
            }
        }
    }

    private static boolean homeWorkSix(int[] arr) {
        boolean rezult = false;
        for (int i = 0; i < arr.length - 1; i++) {
            int right = 0;
            int left = 0;
            for (int x = 0; x <= i; x++) {
                left += arr[x];
            }
            for (int y = arr.length - 1; y > i; y--) {
                right += arr[y];
            }
            if (right == left) {
                rezult = true;
                break;
            }
        }
        return rezult;
    }

    private static void homeWorkFour(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] > max) max = arr[x];
            if (arr[x] < min) min = arr[x];
        }
        System.out.println("Максимальный элемент: " + max + " Минимадьный элемент: " + min);
    }

    private static void homeWorkThree(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] < 6) arr[x] *= 2;
        }
    }

    private static void homeWorkTwo(int[] arr) {
        for (int x = 0; x < arr.length; x++)
            arr[x] = x * 3 + 1;
    }

    private static void homeWorkOne(int[] arr) {
        for (int x = 0; x < arr.length; x++)
            arr[x] = (arr[x] == 1) ? 0 : 1;
    }
}