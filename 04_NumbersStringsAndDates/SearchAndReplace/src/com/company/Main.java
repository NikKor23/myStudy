package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String safe = searchAndReplaceDiamonds("Номер кредитной карты 4008 1234 5678> 8912", "* * ");
    }

    public static String searchAndReplaceDiamonds(String text, String placeHolder){
        text = text.trim();
        placeHolder = placeHolder.trim();
        if (text == "" || placeHolder == "") {
            String err = "Неполные данные";
            System.out.println(err);
            return null;
        }
        int s = text.indexOf("<");
        int e = text.lastIndexOf(">");
        if (s == -1 || e == -1 || s > e) {
            String err = "Укажите значения, которые необходимо скрыть (начало(<) и конец(>))";
            System.out.println(err);
            return null;
        }
        String sub = text.substring(s + 1, e);
        text = text.replace(sub, placeHolder);
        System.out.println(text);
        return text;
    }
}
