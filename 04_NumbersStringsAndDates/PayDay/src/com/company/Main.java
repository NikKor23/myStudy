package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        String name = "Вася 5000 рублей, Петя - 7500 рублей, а Маша - 30000 рублей";
        getPay(name);
    }

    public static void getPay(String string){
        int sum = 0;

        while (string != "") {
            String substr;
            string = string.trim();
            int s = string.indexOf(" ");
            if (s == -1) {
                 substr = string;
            }
            else substr = string.substring(0, s);
            substr = substr.trim();
            String p = "";
            for (int i = 0; i <= substr.length() - 1; i++){
                if (Character.isDigit(substr.charAt(i))) {
                    p = p + substr.charAt(i);
                }
                else {
                    p = "";
                    string = string.replace(substr, "");
                }
            }
            if (p != "") {
                sum = sum + Integer.parseInt(p);
                string = string.replace(substr, "");
            }
        }
        System.out.println(sum);

    }
}
