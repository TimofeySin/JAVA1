package ru.geekbrains.Jawa1.Jawa1Lesson2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        System.out.println("Задание № 1");
        exercise1();
        System.out.println("\nЗадание № 2");
        exercise2();
        System.out.println("\nЗадание № 3");
        exercise3();
        System.out.println("\nЗадание № 4");
        exercise4();
        System.out.println("\nЗадание № 5 перебором");
        exercise51();
        System.out.println("\nЗадание № 5 встроенными функциями");
        exercise52();
        System.out.println("\nЗадание № 6");
        int[] arrayForExercise6 = {2, 1, 1, 2, 1};
        boolean result = exercise6(arrayForExercise6);
        System.out.println("Резудьтат сравнения половин массива " + Arrays.toString(arrayForExercise6) + " равен: " + result);
        System.out.println("\nЗадание № 7");
        int[] arrayForExercise7 = {1, 2, 3, 4, 5};
        int shift = -5;
        System.out.println("Массив: "  + Arrays.toString(arrayForExercise7)+" сдвигаем на " +shift);
        System.out.print("и получаем: ");
        exercise7(shift, arrayForExercise7);
    }

    // Печать массивов байт
    public static void printArray(byte[] arrayForPrint) {
        System.out.println(Arrays.toString(arrayForPrint));
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void exercise1() {

        byte[] arrayForExercise1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};


        for (byte i = 0; i < arrayForExercise1.length; i++) {

            if (arrayForExercise1[i] == 1) {
                arrayForExercise1[i] = 0;
            } else {
                arrayForExercise1[i] = 1;
            }
        }
        printArray(arrayForExercise1);

    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void exercise2() {

        byte[] arrayExercise2 = new byte[8];
        byte num = 0;
        for (byte i = 0; i < arrayExercise2.length; i++) {
            arrayExercise2[i] = num;
            num += 3;
        }

        printArray(arrayExercise2);
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void exercise3() {
        byte[] arrayForExercise3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (byte i = 0; i < arrayForExercise3.length; i++) {
            if (arrayForExercise3[i] < 6) {
                arrayForExercise3[i] *= 2;
            }
        }
        printArray(arrayForExercise3);
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void exercise4() {

        byte[][] arrayExercise4 = new byte[7][7];

        for (byte i = 0; i < arrayExercise4.length; i++) {
            arrayExercise4[i][i] = 1;
            arrayExercise4[arrayExercise4.length - i - 1][i] = 1;
        }

        for (byte i = 0; i < arrayExercise4.length; i++) {
            System.out.println(Arrays.toString(arrayExercise4[i]));
        }
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void exercise51() {
        byte[] arrayForExercise5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        byte maxNum = 0;
        byte minNum = 127;
        for (byte i = 0; i < arrayForExercise5.length; i++) {

            if (maxNum < arrayForExercise5[i]) {
                maxNum = arrayForExercise5[i];
            } else if (minNum > arrayForExercise5[i]) {
                minNum = arrayForExercise5[i];
            }
        }
        System.out.print("В массиве: ");
        printArray(arrayForExercise5);
        System.out.println("Максимальное значение : " + maxNum);
        System.out.println("Минимальное значение : " + minNum);
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void exercise52() {
        byte[] arrayForExercise5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("В массиве: ");
        printArray(arrayForExercise5);
        Arrays.sort(arrayForExercise5);

        System.out.println("Максимальное значение : " + arrayForExercise5[arrayForExercise5.length - 1]);
        System.out.println("Минимальное значение : " + arrayForExercise5[0]);


    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean exercise6(int[] arrayForLesson) {

        int middleArray = (arrayForLesson.length - arrayForLesson.length % 2) / 2;

        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        for (int i = 0; i < arrayForLesson.length; i++) {
            if (i <= middleArray) {
                sumFirstHalf += arrayForLesson[i];
            } else {
                sumSecondHalf += arrayForLesson[i];
            }
        }
        return sumFirstHalf == sumSecondHalf;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void exercise7(int shift, int[] arrayForLesson) {

        int tempNum = 0;
        boolean left;

        if (shift > 0) {
            left = false;
        } else {
            left = true;
            shift = shift * -1;
        }

        tempNum = arrayForLesson[0];
        for (int i = 0; i < shift; i++) {

            for (int y = 0; y < arrayForLesson.length - 1; y++) {
                if (!left) {
                    tempNum = shiftArrayRight(arrayForLesson, y, tempNum);
                } else {
                    tempNum = shiftArrayLeft(arrayForLesson, y, tempNum);
                }
            }

            arrayForLesson[0] = tempNum;
        }







        System.out.println(Arrays.toString(arrayForLesson));

    }

    public static int shiftArrayRight(int[] arrayForLesson, int i, int temp1) {

        int temp2;


        temp2 = arrayForLesson[i + 1];

        arrayForLesson[i + 1] = temp1;

        return temp2;

    }

    public static int shiftArrayLeft(int[] arrayForLesson, int i, int temp1) {

        int temp2;

        temp2 = arrayForLesson[arrayForLesson.length - i-1];

        arrayForLesson[arrayForLesson.length - i-1] = temp1;

        return temp2;

    }


}


