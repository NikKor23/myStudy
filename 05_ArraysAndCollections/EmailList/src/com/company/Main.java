package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        TreeSet<String> emailsList = new TreeSet<>();
        emailsList.add("qwerty@yandex.ru");
        emailsList.add("hello@skillbox.ru");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = string.trim();
        String[] stringArray = string.split("\\s+");
        switch (stringArray[0]) {
            case ("LIST") : {
                if (emailsList.size() == 0) {
                    System.out.println("Нет ни одного email!");
                }
                else {
                    for (String emails : emailsList) {
                        System.out.println(emails);
                    }
                }
                break;
            }
            case ("ADD") : {
                if (stringArray.length == 0) {
                    System.out.println("А что добавлять?");
                    return;
                }
                if (Pattern.matches("[a-zA-z0-9.]*[a-zA-z0-9]@[a-zA-Z]+.[a-z]{2,3}", stringArray[1])) {
                    if (emailsList.contains(stringArray[1])){
                        System.out.println("Такой адрес уже есть");
                        for (String emails : emailsList) {
                            System.out.println(emails);
                        }
                        return;
                    }
                    emailsList.add(stringArray[1]);
                    for (String emails : emailsList) {
                        System.out.println(emails);
                    }
                }
                else {
                    System.out.println("Что за имейл такой?");
                    return;
                }
                break;
            }
            default:
                System.out.println("Ничего не понимаю!");

        }
    }
}
