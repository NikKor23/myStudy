package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> toDoList = new ArrayList<>();
        toDoList.add("Первое дело");
        toDoList.add("Второе дело");
        toDoList.add("Третье дело");
        toDoList.add("Четвёртое дело");
        toDoList.add("Пятое дело");
        toDoList.add("Шестое дело");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = string.trim();
        String arrayString[] = string.split("\\s+");
        switch (arrayString[0]) {
            case ("LIST"): {
                if (toDoList.size() == 0) {
                    System.out.println("Список дел пуст!");
                 return;
                }
                else {
                    for (int i = 0; i < toDoList.size(); i++) {
                        System.out.println(i + " " + toDoList.get(i));
                    }
                }
                break;

            }
            case ("ADD"): {
                if (arrayString.length == 1) {
                    System.out.println("Что добавлять?");
                }
                else if (isNumber(arrayString[1])){
                    if (arrayString.length == 2) {
                        System.out.println("Вы не ввели название дела");
                        return;
                    }
                    else {
                        int addNumber = Integer.parseInt(arrayString[1]);
                        if (addNumber > toDoList.size() - 1) {
                           addNumber = toDoList.size();
                            System.out.println("Номер дела больше списка, дело добавлено в конец");
                        }
                        String addName = "";
                        for (int i = 2; i <= arrayString.length - 1; i++){
                            addName = addName + arrayString[i];
                        }
                        toDoList.add(addNumber,addName);
                        for (int i = 0; i < toDoList.size(); i++) {
                            System.out.println(i + " " + toDoList.get(i));
                        }
                    }
                }
                else {
                    String addName  = "";
                    for (int i = 1; i <= arrayString.length - 1; i++){
                        addName = addName + arrayString[i];
                    }
                    toDoList.add(addName);
                    for (int i = 0; i < toDoList.size(); i++) {
                        System.out.println(i + " " + toDoList.get(i));
                    }
                }
                break;
            }
            case ("DELETE"): {
                if (arrayString.length == 1) {
                    System.out.println("Что удалять?");
                }
                else {
                    if (isNumber(arrayString[1])) {
                        int deleteNumber = Integer.parseInt(arrayString[1]);
                        if (deleteNumber > toDoList.size() - 1) {
                            System.out.println("Такого дела нет!");
                            return;
                        }
                        toDoList.remove(deleteNumber);
                        for (int i = 0; i < toDoList.size(); i++) {
                            System.out.println(i + " " + toDoList.get(i));
                        }
                    }
                    else System.out.println("Не могу понять, что ты хочеш удалить?");
                }
                break;
            }
            case ("EDIT"): {
                if (arrayString.length == 1) {
                    System.out.println("Что исправлять?");
                }
                else if (isNumber(arrayString[1])) {
                        if (arrayString.length == 2) {
                            System.out.println("Вы не ввели новое название");
                            return;
                        }
                        int editNumber = Integer.parseInt(arrayString[1]);
                        if (editNumber > toDoList.size() - 1) {
                            System.out.println("Такого дела нет!");
                            return;
                        }
                    toDoList.remove(editNumber);
                    String editName = "";
                    for (int i = 2; i <= arrayString.length - 1; i++){
                            editName = editName + arrayString[i];
                    }
                    toDoList.add(editNumber, editName);
                    for (int i = 0; i < toDoList.size(); i++) {
                            System.out.println(i + " " + toDoList.get(i));
                    }
                    }
                else {
                    System.out.println("Какое дело по счёту исправлять?");
                }
                break;
            }
            default:
                System.out.println("Ничего не понимаю!!!");
        }

    }

    public static boolean isNumber (String string) {
        int p = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) p++;
        }
        if (p == string.length()) return true;
        else return false;

    }
}
