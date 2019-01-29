package ru.geekbrains.Jawa1.Jawa1Lesson7;

public class Plate {
    private int food;

    public void setFood(int food) {
        this.food = food;
    }

    //        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
    //        (например, в миске 10 еды, а кот пытается покушать 15-20)
    public void decreaseFood(int amount) {
        if ((food - amount)>=0) {
            food -= amount;
        }
    }

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Food: " + food);
    }


    public void addFood(int food){
        this.food += food;
    }
}
