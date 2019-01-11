package ru.geekbrains.Jawa1.Jawa1Lesson7;

//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
//        Если коту удалось покушать (хватило еды), сытость = true

public class Cat {
    private String name;
    private boolean full;


    public Cat(String name) {
        this.name = name;
    }

    //        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт
    //        (это сделано для упрощения логики программы)
    public void eat(Plate p) {
        int catFood = 10;

        if ((p.getFood() - catFood) >= 0) {
            System.out.println(name + " кушает");
            p.decreaseFood(catFood);
            full = true;
        } else {
            System.out.println("Для " + name + " в этой тарелке мало еды.");
        }



    }

    public void info() {
        System.out.println("Кот " + name + (full ? " сыт":" голоден")+".");
    }

}
