package com.geekbrains.java2.lesson2.homework;

public class ArrayCheck {

    public static int arrayCheck(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Length of an array not equals to 4");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum+= Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("Incorrect data format in cell [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}
