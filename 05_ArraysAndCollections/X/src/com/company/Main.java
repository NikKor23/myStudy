package com.company;

public class Main {
    public static final int SIZE = 5;

    public static void main(String[] args) {

        String [] [] array = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                array[i][j] = " ";
                if (i == j || i + j == SIZE - 1) array[i][j] = "X";
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
