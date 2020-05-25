package com.geekbrains.java2.lesson3.homework;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {

    HashMap<String, HashSet<String>> phonebook;

    public Phonebook() { this.phonebook = new HashMap<>(); }

    public void add(String name, String phone) {
        HashSet<String> book = phonebook.getOrDefault(name, new HashSet<>());
        book.add(phone);
        phonebook.put(name, book);
    }

    public void get(String name) {
        System.out.println(name + " : " + phonebook.getOrDefault(name, new HashSet<>()));
    }
}
