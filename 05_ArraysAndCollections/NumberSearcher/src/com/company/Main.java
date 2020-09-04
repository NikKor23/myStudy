package com.company;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String[] letters = {"A","B","C","E","H","K","M","O","P","T","X","Y"};
        ArrayList<String> numbers = new ArrayList<>();
        int count = 0;
            for (int i1 = 0; i1 < letters.length; i1++) {
                for (int j = 111; j <= 999; j = j + 111) {
                    for (int i2 = 0; i2 < letters.length; i2++) {
                        for (int i3 = 0; i3 < letters.length; i3++) {
                            for (int i = 1; i <= 197; i++) {
                                numbers.add(letters[i1] + j + letters[i2] + letters[i3] + i);
                                count++;
                            }
                        }
                    }
                }
            }
        Collections.sort(numbers);
        System.out.println("Всего номеров " + count + "\nВведите номер для поиска: ");

        HashSet <String> numbersHash = new HashSet<>();
        numbersHash.addAll(numbers);

        TreeSet<String> numbersTree = new TreeSet<>();
        numbersTree.addAll(numbers);

        Scanner scanner = new Scanner(System.in);

        for (;;) {
            String numberToFind = scanner.nextLine();
            numberToFind = numberToFind.trim();
            if (!Pattern.matches("^[A-Z]\\d{3}[A-Z][A-Z]\\d{1,3}$", numberToFind)){
                System.out.println("Это не является автомобильным номером!");
                continue;
            }

            boolean exist = false;
            System.out.print("Поиск перебором: ");
            long start = System.nanoTime();
            if (numbers.contains(numberToFind)) {
                System.out.print("номер найден. ");
                exist = true;
            }
            if (!exist) System.out.print("номер не найден. ");
            long end = System.nanoTime();
            System.out.println("Потрачено времени: " + (end - start) + " нс");

            System.out.print("Бинарный поиск: ");
            start = System.nanoTime();
            int index = Collections.binarySearch(numbers, numberToFind);
            if (index < 0) System.out.print("номер не найден. ");
            else System.out.print("номер найден. ");
            end = System.nanoTime();
            System.out.println("Потрачено времени: " + (end - start) + " нс");

            System.out.print("Поиск в HashSet: ");
            start = System.nanoTime();
            if (numbersHash.contains(numberToFind)) System.out.print("номер найден. ");
            else System.out.print(" номер не найден. ");
            end = System.nanoTime();
            System.out.println(" Потрачено времени: " + (end - start) + " нс");

            System.out.print("Поиск в TreeSet: ");
            start = System.nanoTime();
            if (numbersTree.contains(numberToFind)) System.out.print("номер найден. ");
            else System.out.print(" номер не найден. ");
            end = System.nanoTime();
            System.out.println(" Потрачено времени: " + (end - start) + " нс");
        }
    }

}
