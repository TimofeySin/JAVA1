package ru.geekbrains.Jawa1.Jawa1Lesson4;

import java.util.Random;
import java.util.Scanner;
//
public class Lesson4 {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static char[][] map;

    static final char DOT_EMPTY = '*';
    static final char DOT_PLAYER = 'X';
    static final char DOT_BOT = 'O';

    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            playerTurn();
            printMap();
            if (checkWinLines(DOT_PLAYER)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinLines(DOT_BOT)) {
                System.out.println("Победил бот");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    static boolean checkLine(int cx, int cy, int vx, int vy, char dot) {
        if (cx + vx * DOTS_TO_WIN - 1 > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 < 0) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cx + i * vx][cy + i * vy] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 1, 0, dot) || checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 1, dot) || checkLine(i, j, 1, -1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода в формате \"x y\"");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[y][x] = DOT_PLAYER;
    }

    static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[y][x] = DOT_BOT;
        System.out.println("Бот походил в клетку " + (x + 1) + " " + (y + 1));
    }

    static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char dot) {
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) {
            return true;
        }
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) {
            return true;
        }
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) {
            return true;
        }

        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) {
            return true;
        }
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) {
            return true;
        }
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) {
            return true;
        }

        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) {
            return true;
        }
        if (map[0][2] == dot && map[1][1] == dot && map[2][0] == dot) {
            return true;
        }

        return false;
    }
}