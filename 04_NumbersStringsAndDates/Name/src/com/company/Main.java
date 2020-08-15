package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите ФИО (Например: Терентьев Михаил Павлович)");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        showNameNew(name);
    }

    public static void showNameNew (String fio) {
        fio = fio.trim();
        int err = 0;
        for (int i = 0; i <= fio.length() - 1; i++) {
            if (Character.isDigit(fio.charAt(i))) {
                System.out.println("Вы ввели цифры");
                err = 1;
                break;
            }
        }
        if (fio.length() == 0 || err == 1) {
            System.out.println("Неверный формат имени!");
        }
        else {
            String[] string = fio.split("\\s+", 3);
            for (int i = 0; i <= string.length - 1; i++) {
                switch (i) {
                    case 0:
                        System.out.println("Фамилия: " + string[i]);
                        break;
                    case 1:
                        System.out.println("Имя: " + string[i]);
                        break;
                    case 2:
                        System.out.println("Отчество: " + string[i]);
                        break;
                }

            }
        }
    }

    public static void showName(String fio){
        int i = 0;
        String str1 = "", str2 = "", str3 = "", substr;
        while (i < 3) {
            fio = fio.trim();
            if (fio == "" || fio == " ") break;
            int spaceIndex = fio.indexOf(" ");
            if (spaceIndex == -1) substr = fio;
            else substr = fio.substring(0, spaceIndex);
            substr = substr.trim();
            if (i == 0) {
                str1 = substr;
                fio = fio.replace(substr, "");
                i++;
                continue;
            }
            if (i == 1) {
                str2 = substr;
                fio = fio.replace(substr, "");
                i++;
                continue;
            }
            else {
                str3 = substr;
                fio = fio.replace(substr, "");
                i++;
                continue;
            }
        }
        System.out.println("Фамилия: " + str1);
        System.out.println("Имя: " + str2);
        System.out.println("Отчество: " + str3);

    }
}
