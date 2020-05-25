package com.geekbrains.java2.lesson3.homework;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Phonebook phonebookMain = new Phonebook();

        phonebookMain.add("Lannister", "+7-111-222-33-44");
        phonebookMain.add("Stark", "+7-222-333-44-55");
        phonebookMain.add("Snow", "+7-333-444-55-66");
        phonebookMain.add("Tirel", "+7-444-555-66-77");

        System.out.println("Task 1.");

        arrayFilter();

        System.out.println("\nTask 2.");

        phonebookMain.get("Lannister");
        phonebookMain.get("Stark");
    }

    public static void arrayFilter() {
        String[] words = {"apple", "GREECE", "apple", "GREECE",
                "red", "white", "black", "covid",
                "white", "GREECE", "GREECE", "red",
                "white", "black", "red", "white"};

        HashMap<String, Integer> uniqueWords = new HashMap<>();

        for (String x : words) { uniqueWords.put(x, uniqueWords.getOrDefault(x,0)+1); }
        System.out.println(uniqueWords);
    }
}
