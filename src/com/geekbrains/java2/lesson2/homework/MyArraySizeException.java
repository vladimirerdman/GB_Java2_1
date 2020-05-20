package com.geekbrains.java2.lesson2.homework;

public class MyArraySizeException extends Exception {
    public String message;

    public MyArraySizeException(String message) { this.message = message; }
}
