package com.geekbrains.java2.lesson5.homework;

import java.util.Arrays;

public class HomeworkFive {
    private static final int size = 10000000;
    private static final int n = 4;
    private static final int h = size / n;
    private static float[] arr = new float[size];

    public static void main(String[] args) {
        HomeworkFive homeworkFive = new HomeworkFive();
        homeworkFive.firstPart();
        homeworkFive.secondPart();
    }

    private void firstPart() {
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println("Execution time of first param: " + (end - a));
    }

    private void secondPart() {
        Thread[] threads = new Thread[n];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        float[][] newArr = new float[n][h];

        for (int i = 0; i < n; i++) { System.arraycopy(arr, i*h, newArr[i], 0, h); }

        long split = System.currentTimeMillis();
        System.out.println("Splitting time of an Array: " + (split - a));

        for(int i=0; i < n; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> calcSecondArr(newArr, finalI));
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        long concat = System.currentTimeMillis();
        for (int i = 0; i < n; i++) { System.arraycopy(newArr[i], 0, arr, i*h, h); }
        long end = System.currentTimeMillis();
        System.out.println("Bonding time of an Array: " + (end - concat));
        System.out.println("Execution time of second param: " + (end - a));
    }

    private void calcSecondArr(float[][] arr, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
            arr[n][i] = (float) (arr[n][i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time of " + (n+1) + " thread " + (end - start));
    }
}