package com.company;

import java.util.Scanner;

public class Main {

    public static final int MAX_BOXES = 27;
    public static final int MAX_CONTAINS = 12;

    public static void main(String[] args) {

        System.out.println("Введите колличесство ящиков:");
        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();
        int containers = boxes / MAX_BOXES;
        if (boxes % MAX_BOXES != 0) containers++;
        int trucks = containers / MAX_CONTAINS;
        if (containers % MAX_CONTAINS != 0) trucks++;       // Эта часть для проверки
        System.out.println(containers + "  " + trucks);

        int t = 1;
        int c = 1;
        System.out.println("Грузовик " + t);
        System.out.println("Контейнер " + c);
        for (int b = 1; b <= boxes; b++){
            System.out.println("\tЯщик " + b);
            if (b % (MAX_BOXES * MAX_CONTAINS) == 0) System.out.println("Грузовик " + ++t);
            if (b % MAX_BOXES == 0) System.out.println("Контейнер " + ++c);

        }
    }
}
