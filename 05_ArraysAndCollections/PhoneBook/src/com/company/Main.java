package com.company;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        phoneBook.put("Павлов Георгий", "+71165342693");
        phoneBook.put("Суслин Виктор", "+79986467326");
        phoneBook.put("Иванов Василий", "+78936545666");
        phoneBook.put("Авоськин Василий", "+79645386651");


        Scanner scanner = new Scanner(System.in);
         for (;;) {

             System.out.println("Введите номер телефона в формате +71234567890 \nИли имя в формате Фамилия Имя \n" +
                     "Команда LIST - все контакты");
             String nameOrNumber = scanner.nextLine();
             nameOrNumber = nameOrNumber.trim();

             if (nameOrNumber.equals("LIST")) {
                 printMap(phoneBook);
                 continue;
             }

             if (Pattern.matches("^[А-Я][а-я]+\\s+[А-Я][а-я]+$", nameOrNumber)) {
                if (phoneBook.containsKey(nameOrNumber)) {
                    System.out.println("Контаут существует! \n" + nameOrNumber + " " + phoneBook.get(nameOrNumber));
                }
                else {
                    System.out.println("Такого контакта нет! Введите номер для создания контакта.");
                    String number = scanner.nextLine();
                    if (Pattern.matches("^\\+7\\d{10}$", number)) {
                        phoneBook.put(nameOrNumber, number);
                        System.out.println("Контакт создан \n" + nameOrNumber + " " + phoneBook.get(nameOrNumber));

                    }
                    else {
                        System.out.println("Это не является номером");
                    }
                }
                continue;
             }
             if (Pattern.matches("^\\+7\\d{10}$", nameOrNumber)) {
                 boolean exist = false;
                 for (String contact : phoneBook.keySet()) {
                     if (phoneBook.get(contact).equals(nameOrNumber)) {
                     System.out.println("Контакт существует! \n" + contact + " " + phoneBook.get(contact));
                     exist = true;
                     }
                 }
                 if (!exist) {
                     System.out.println("Контакта не существует! Введите имя контакта");
                     String number = scanner.nextLine();
                     if (Pattern.matches("^[А-Я][а-я]+\\s+[А-Я][а-я]+$", number)) {
                         phoneBook.put(number, nameOrNumber);
                     } else {
                         System.out.println("Неверный формат имени!");
                     }
                 }
                 continue;
             }
             else {
                 System.out.println("Не понимаю!");
             }
         }


    }

    private static void printMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
