package ru.geekbrains.java_one_lesson_one;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';

    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int winSize;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        winSize = 4;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.println("------");
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        if (!checkAI(DOT_AI) && !checkAI(DOT_HUMAN)) {
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isEmptyCell(x, y));
            field[y][x] = DOT_AI;
        }
    }

    private static boolean checkAI (int c){
        for (int y = 0; y < fieldSizeY; y++) {
            int winX = 0;
            int winY = 0;
            int winXY1 = 0;
            int winXY2 = 0;
            int winYX1 = 0;
            int winYX2 = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c) {
                    winX++;
                    if (winX == winSize - 1) {
                        for (int i = x + 1; i >= x + 1 - winSize; i--) {
                            if (isValidCell(i, y) && isEmptyCell(i, y)) {
                                field[y][i] = DOT_AI;
                                return true;
                            }
                        }
                    }
                }
                if (field[x][y] == c) {
                    winY++;
                    if (winY == winSize - 1) {
                        for (int i = x + 1; i >= x + 1 - winSize; i--) {
                            if (isValidCell(y, i) && isEmptyCell(y, i)) {
                                field[i][y] = DOT_AI;
                                return true;
                            }
                        }
                    }
                }
            }
            for (int x = 0; x < fieldSizeX - y; x++) {
                if (field[x][x + y] == c) {
                    winXY1++;
                    if (winXY1 == winSize - 1) {
                        int j = x + 1;
                        for (int i = x + y + 1; i >= x + y + 1 - winSize; i--) {
                            if (isValidCell(i, j) && isEmptyCell(i, j)) {
                                field[j][i] = DOT_AI;
                                return true;
                            }
                            j--;
                        }
                    }
                }
                if (field[x + y][x] == c) {
                    winXY2++;
                    if (winXY2 == winSize - 1) {
                        int j = x + y + 1;
                        for (int i = x + 1; i >= x + 1 - winSize; i--) {
                            if (isValidCell(i, j) && isEmptyCell(i, j)) {
                                field[j][i] = DOT_AI;
                                return true;
                            }
                            j--;
                        }
                    }
                }
                if (field[x][fieldSizeX - 1 - (x + y)] == c) {
                    winYX1++;
                    if (winYX1 == winSize - 1) {
                        int j = x + 1;
                        for (int i = fieldSizeX - 1 - (x + y) - 1; i <= fieldSizeX - 1 - (x + y) - 1 + winSize; i++) {
                            if (isValidCell(i, j) && isEmptyCell(i, j)) {
                                field[j][i] = DOT_AI;
                                return true;
                            }
                            j--;
                        }
                    }
                }
                if (field[x + y][fieldSizeX - 1 - x] == c) {
                    winYX2++;
                    if (winYX2 == winSize - 1) {
                        int j = x + y + 1;
                        for (int i = fieldSizeX - 1 - x - 1; i <= fieldSizeX - 1 - x - 1 + winSize; i++) {
                            if (isValidCell(i, j) && isEmptyCell(i, j)) {
                                field[j][i] = DOT_AI;
                                return true;
                            }
                            j--;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        for (int y = 0; y < fieldSizeY; y++) {
            int winY = 0;
            int winX = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == c) winX++;
                else winX = 0;
                if (field[x][y] == c) winY++;
                else winY = 0;
                if (winX == winSize || winY == winSize) return true;
            }
        }
        for (int y = 0; y < fieldSizeY; y++) {
            int winXY = 0;
            int winYX = 0;
            for (int x = 0; x < fieldSizeX - y; x++) {
                if (field[x][x + y] == c) winXY++;
                else if (field[x + y][x] == c) winXY++;
                else winXY = 0;

                if (field[x][fieldSizeX - 1 - (x + y)] == c) winYX++;
                else if (field[x + y][fieldSizeX - 1 - x] == c) winYX++;
                else winYX = 0;if (winXY == winSize || winYX == winSize) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        while (true) {
        playOneRound();
            System.out.println("Play again?");
            if (SCANNER.next().equals("no"))
                break;
        }
    }

    private static void playOneRound() {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Выйграл человек!!!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Выйграл AI!!!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
    }
}