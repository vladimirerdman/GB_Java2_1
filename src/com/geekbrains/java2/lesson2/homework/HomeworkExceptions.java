package com.geekbrains.java2.lesson2.homework;

public class HomeworkExceptions {

    public static void main(String[] args) {
        String[][] arStringNm = new String[4][4];

        arStringNm[0][0] = "235";
        arStringNm[0][1] = "436";
        arStringNm[0][2] = "34634";
        arStringNm[0][3] = "23423";
        arStringNm[1][0] = "s";
        arStringNm[1][1] = "235";
        arStringNm[1][2] = "123";
        arStringNm[1][3] = "246";
        arStringNm[2][0] = "346346";
        arStringNm[2][1] = "124";
        arStringNm[2][2] = "2345";
        arStringNm[2][3] = "124";
        arStringNm[3][0] = "346";
        arStringNm[3][1] = "23523";
        arStringNm[3][2] = "346";
        arStringNm[3][3] = "1234";

        try{
            System.out.println(ArrayCheck.arrayCheck(arStringNm));
        } catch (MyArraySizeException e){
            System.out.println(e.message);
        } catch (MyArrayDataException e) {
            System.out.println(e.message);
        }
    }

}