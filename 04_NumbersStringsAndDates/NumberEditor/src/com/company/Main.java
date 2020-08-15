package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        numberEditor(number);

    }

    public static void numberEditor(String num) {
        String number = num.replaceAll("\\D", "");
        int l = number.length();
        if (number.length() == 11) {
            int first = Character.getNumericValue(number.charAt(0));
            if (first == 7) {
                System.out.println(number);
                return;
            }
            if (first == 8) {
                number = number.replace("8", "7");
                System.out.println(number);
                return;
            }
            else {
                System.out.println("Неверный формат номера");
                return;
            }

        }
        if (number.length() == 10) {
            number = "7" + number;
            System.out.println(number);
        }
        else System.out.println("Неверный формат номера");
    }
}
