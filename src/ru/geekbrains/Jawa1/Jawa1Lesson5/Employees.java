package ru.geekbrains.Jawa1.Jawa1Lesson5;

//* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
//        * Конструктор класса должен заполнять эти поля при создании объекта;
//        * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
public class Employees {

    private String fio;
    private String post;
    private String eMail;
    private int phoneNumber;
    private float salary;
    private byte age;

    public Employees(String fio, String post, String eMail, int phoneNumber, float salary, byte age) {
        this.fio = fio;
        this.post = post;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "ФИО: " +fio+ "; Должность: "+post+ "; eMail: "+eMail+ "; Телефон: "+phoneNumber+ "; Зарплата: "+salary+ "; Возраст: "+age;
    }
}
