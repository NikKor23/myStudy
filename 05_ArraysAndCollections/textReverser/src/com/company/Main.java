package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите предложение");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = string.trim();
        if (string.length() == 0) {
            System.out.println("Вы ничего не ввели");
        }
        else if (string.indexOf(" ") == -1) {
            System.out.println("Вы ввели одно слово");
        }
        else {
            String stringArray[] = string.split("\\s+");
            String stringRevers[] = new String[stringArray.length];
            for (int i = stringArray.length - 1; i >= 0; i--) {
                for (int j = 0; j <= stringArray.length ; j++ ){
                    stringRevers[j] = stringArray[i];
                    System.out.print(stringRevers[j] + " ");
                    break;
                }
        }
        }
    }
}
