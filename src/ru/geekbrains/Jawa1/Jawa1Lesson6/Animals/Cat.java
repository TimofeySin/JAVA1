package ru.geekbrains.Jawa1.Jawa1Lesson6.Animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.voice = "мяу";
        this.maxDistanceRun = 200;
        this.maxDistanceSwim = 0;
        this.maxHeightJump = 2f;
    }

    public Cat(String name, int maxDistanceRun,  float maxHeightJump) {
        super(name);
        this.voice = "мяу";
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = 0;
        this.maxHeightJump = maxHeightJump;
    }

    @Override
    public String toString() {
        return "Кошка по имени " + name+ " сказала " + voice;
    }

}
