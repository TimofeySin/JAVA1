package ru.geekbrains.Jawa1.Jawa1Lesson5;

public class Lesson5 {

    public static void main(String[] args) {
        //        * Создать массив из 5 сотрудников
        Employees[] persArray = new Employees[5];
        persArray[0] = new Employees("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 892312312, 60000.0f, (byte) 30);
        persArray[1] = new Employees("Petrov Nikolay", "Manager", "ivivan@mailbox.com", 892312312, 50000.0f, (byte) 28);
        persArray[2] = new Employees("Sidorov Evgenii", "Director", "ivivan@mailbox.com", 892312312, 500000.0f, (byte) 50);
        persArray[3] = new Employees("Ushkow Aleksandr", "Programmer", "ivivan@mailbox.com", 892312312, 120000.0f, (byte) 41);
        persArray[4] = new Employees("Nikolaev Petr", "Cleaner", "ivivan@mailbox.com", 892312312, 30000.0f, (byte) 54);

        printEmployeesOlder(persArray,(byte) 40);
    }
    //        * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    public static void printEmployeesOlder(Employees[] persArray, byte age) {
        for (Employees Employee : persArray) {
            if (Employee.getAge() >= age) {
                System.out.println(Employee);
            }
        }
    }

}


