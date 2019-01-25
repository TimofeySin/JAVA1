package ru.geekbrains.Jawa1.Jawa1Lesson6.Animals;

///      2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина,
//        означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
public abstract class Animal {
    int maxDistanceRun;
    int maxDistanceSwim;
    float maxHeightJump;
    String name;
    String voice;

    public Animal( String name) {
        this.name = name;
    }

    public String run(int distance) {
        String mesure = "метров";

        if (distance > maxDistanceRun) {
            return erroreMove(distance, maxDistanceRun, "пробежать", mesure);
        }
        return name + " пробежал " + distance + " " + mesure;
    }

    public String swim(int distance) {
        String mesure = "метров";

        if (distance > maxDistanceSwim) {
            return erroreMove(distance, maxDistanceSwim, "проплыть", mesure);
        }
        return name + " проплыл " + distance + " " + mesure;
    }

    private String erroreMove(int distance, int max, String typeMove, String mesure) {
        if (max ==0) {
            return name +" не может " + typeMove +", потому что не умеет.";
        }
        return name + " не может " + typeMove + "\nне хватает " + (distance - max) + " " + mesure + ".";
    }

    private String erroreMove(float distance, float max, String typeMove, String mesure) {
        if (max ==0) {
            return name +" не может " + typeMove +", потому что не умеет.";
        }
        return name + " не может " + typeMove + "\nне хватает " + (distance - max) + " " + mesure + ".";
    }

    public String jump(float distance) {
        String mesure = "метра";

        if (distance > maxHeightJump) {
            return erroreMove(distance, maxHeightJump, "прыгнуть", mesure);
        }
        return name + " прыгнул на " + distance + " " + mesure;
    }

    public void voice() {
        System.out.println(voice);
    }


}
