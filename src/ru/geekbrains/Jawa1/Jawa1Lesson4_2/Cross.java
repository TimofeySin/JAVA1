package ru.geekbrains.Jawa1.Jawa1Lesson4_2;

import java.util.Random;
import java.util.Scanner;

public class Cross {

    static int SIZE_X = 3;
    static int SIZE_Y = 3;

    static char[][] field = new char[SIZE_X][SIZE_Y];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static char PLAYER_DOT = 'X';
    static char AI_DOT = '0';
    static char EMPTY_DOT = '.';

    static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    static void printField() {
        for (int i = 0; i < SIZE_Y; i++) {
            if (i == 0) {
                System.out.print("   " + (i + 1) + "  ");
            } else {
                System.out.print((i + 1) + "  ");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + " |");
            }
            System.out.println();
        }
    }

    static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты X и Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, PLAYER_DOT);
    }

    /**
     * Ход компьютера
     */
    static void aiStep() {

        //проверка + счетчик
        //const = 2
        System.out.println("Ходит комп");
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSym(y, x, AI_DOT);
    }

    /**
     * Возможность установки X или 0 в поле
     *
     * @param y - координата по y
     * @param x - координата по x
     * @return можно или нет
     */
    static boolean isCellValid(int y, int x) {
        if (x < 0 || x >= SIZE_X || y < 0 || y >= SIZE_Y) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    static boolean checkWin(char sym) {
        //region Проверка
        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
            return true;
        }
        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
            return true;
        }
        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
            return true;
        }
        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) {
            return true;
        }
        //endregion
        return false;
    }

    static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Игрок выиграл!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiStep();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("Комп выиграл!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
