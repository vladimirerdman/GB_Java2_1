package com.geekbrains.java2.lesson1;

public class User {
    public String getName() {
        return name;
    }

    private int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String position;
    private int age;

    public User(int id, String name, String position, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
    }

    void info() {
        System.out.println("id: " + id + "; Имя пользователя: " + name+ "; Должность: " + position + "; Возраст: " + age);
    }

    public void changePosition(String position) {
        this.position = position;
        System.out.println("Пользователь " + name + " получил новую должность: " + position);
    }

    public static void main(String[] args) {
        User firstUser = new User(1, "Peter", "CEO", 42);
        User secondUser = new User(2, "John","Assistant", 25);
        User thirdUser = new User(2, "John","Assistant", 25);
    }
}