package ru.geekbrains.Jawa1.Jawa1Lesson6.Animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.voice = "гав-гав";
        this.maxDistanceRun = 500;
        this.maxDistanceSwim = 10;
        this.maxHeightJump = 0.5f;
    }

    public Dog(String name, int maxDistanceRun, int maxDistanceSwim, float maxHeightJump) {
        super(name);
        this.voice = "гав-гав";
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxHeightJump =maxHeightJump;
    }

    @Override
    public String toString() {
        return "Собака по имени " + name+ " сказала " + voice;
    }
}

