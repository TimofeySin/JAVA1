package ru.geekbrains.Jawa1.Jawa1Lesson6;


import ru.geekbrains.Jawa1.Jawa1Lesson6.Animals.Animal;
import ru.geekbrains.Jawa1.Jawa1Lesson6.Animals.Cat;
import ru.geekbrains.Jawa1.Jawa1Lesson6.Animals.Dog;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson6 {
    private static Scanner scanner = new Scanner(System.in);
    private static int typeMove;
    private static float distance;

    public static void main(String[] args) {

        String res;
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Barsik");
        animals[1] = new Cat("Murzik", 250, 3f);
        animals[2] = new Dog("Sharik");
        animals[3] = new Dog("Bobik", 800, 15, 0.8f);
        System.out.println(Arrays.toString(animals)+"\n");
        while (true) {
            outMenu(animals);
            inputFromUser();
            if (typeMove == 0) {
                System.out.println("Досвидания");
                break;
            }
            followSteps(animals);
        }

        scanner.close();
    }

    private static void followSteps(Animal[] animals) {

        for (Animal animal : animals) {
            switch (typeMove) {
                case 1:
                    System.out.println(animal.run((int) distance));
                    break;
                case 2:
                    System.out.println(animal.jump(distance));
                    break;
                case 3:
                    System.out.println(animal.swim((int) distance));
                    break;
                case 4:
                    animal.voice();
                    break;
                default:
                    System.out.print("Животное не поняло что делать и сказала ");
                    animal.voice();
                    break;
            }
        }

    }


    public static void inputFromUser() {
        typeMove = scanner.nextInt();

        if (typeMove != 4 && typeMove != 0) {
            distance = scanner.nextFloat();
        } else {
            distance = 0;
        }
    }

    public static void outMenu(Animal[] animals) {

        System.out.println("\nЖивотные умеют:");
        System.out.println("1. Бегать");
        System.out.println("2. Прыгать");
        System.out.println("3. Плавать");
        System.out.println("4. Издавать звуки");
        System.out.println("0. Выход");
        System.out.println("Введите номер действия и растояние через пробел (2 3,2)");
    }


}

//        1. Создать классы Собака и Кот с наследованием от класса Животное.
//        2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина,
//        означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//        3. У каждого животного есть ограничения на действия
//        (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//        4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
//        (Например, dog1.run(150); -> результат: run: true)
//        5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.


